package com.example.litthu_eyelash_app.presentation.widget

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Velocity
import androidx.compose.ui.unit.dp
import com.example.litthu_eyelash_app.presentation.theme.AppColors
import com.example.litthu_eyelash_app.presentation.theme.AppDimens
import com.example.litthu_eyelash_app.presentation.theme.AppTextSize
import com.example.litthu_eyelash_app.utils.Constants
import kotlinx.coroutines.launch
import litthu_eyelash_app.litthuapp.generated.resources.Res
import litthu_eyelash_app.litthuapp.generated.resources.default_pull_to_refresh
import litthu_eyelash_app.litthuapp.generated.resources.default_release_to_refresh
import org.jetbrains.compose.resources.stringResource

@Composable
fun OverscrollLazyColumn(
    // Pull to refresh
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    isPullToRefreshTextVisible: Boolean = false,
    pullToRefreshText: String = Constants.EMPTY,
    releaseToRefreshText: String = Constants.EMPTY,

    // Load more
    hasMore: Boolean = false,
    isLoadingMore: Boolean = false,
    onLoadMore: (() -> Unit)? = null,
    loadMoreThreshold: Int = 0, // 3 items left -> call load more
    loadMoreFooter: (@Composable () -> Unit)? = null,
    endOfListFooter: (@Composable () -> Unit)? = null,
    loadMoreText: String? = null,
    noMoreContentText: String? = null,

    // Layout
    modifier: Modifier = Modifier,
    thresholdDp: Int = 72,
    dragDamping: Float = 0.5f,
    contentPadding: PaddingValues = PaddingValues(AppDimens.DIMEN_0),
    content: LazyListScope.() -> Unit
) {
    val listState = rememberLazyListState()
    val density = LocalDensity.current
    val thresholdPx = with(density) { thresholdDp.dp.toPx() }

    // Pull-to-refresh header height (px)
    val offsetPx = remember { Animatable(0f) }
    val scope = rememberCoroutineScope()

    // Animate
    LaunchedEffect(isRefreshing, thresholdPx) {
        if (isRefreshing) {
            offsetPx.animateTo(
                targetValue = thresholdPx,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMediumLow
                )
            )
        } else {
            offsetPx.animateTo(
                targetValue = 0f,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMediumLow
                )
            )
        }
    }

    fun atTop(): Boolean =
        listState.firstVisibleItemIndex == 0 && listState.firstVisibleItemScrollOffset == 0

    val connection = remember(isRefreshing, thresholdPx, dragDamping) {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val dy = available.y
                return if (dy > 0 && atTop() && !isRefreshing) {
                    // Pull -> expand header
                    val consume = dy * dragDamping
                    scope.launch {
                        offsetPx.snapTo((offsetPx.value + consume).coerceAtLeast(0f))
                    }
                    Offset(0f, consume)
                } else Offset.Zero
            }

            override fun onPostScroll(
                consumed: Offset,
                available: Offset,
                source: NestedScrollSource
            ): Offset {
                val dy = available.y
                return if (dy < 0 && offsetPx.value > 0f && !isRefreshing) {
                    // Push -> collapse header
                    val newVal = (offsetPx.value + dy).coerceAtLeast(0f)
                    val actually = newVal - offsetPx.value
                    scope.launch { offsetPx.snapTo(newVal) }
                    Offset(0f, actually)
                } else Offset.Zero
            }

            override suspend fun onPreFling(available: Velocity): Velocity {
                // Release
                if (offsetPx.value > 0f && !isRefreshing) {
                    return if (offsetPx.value >= thresholdPx) {
                        offsetPx.snapTo(thresholdPx)
                        onRefresh.invoke()
                        available
                    } else {
                        offsetPx.animateTo(
                            0f,
                            spring(
                                dampingRatio = Spring.DampingRatioNoBouncy,
                                stiffness = Spring.StiffnessMediumLow
                            )
                        )
                        available
                    }
                }
                return Velocity.Zero
            }
        }
    }

    // Trigger load‑more if loadMoreThreshold is touched
    LaunchedEffect(listState, isLoadingMore, hasMore, isRefreshing, loadMoreThreshold) {
        snapshotFlow {
            val info = listState.layoutInfo
            val lastVisible = info.visibleItemsInfo.lastOrNull()?.index ?: 0
            val total = info.totalItemsCount
            lastVisible to total
        }.collect { (lastVisible, total) ->
            // Note: total đã gồm header/footer nếu có
            if (
                hasMore &&
                !isLoadingMore &&
                !isRefreshing &&
                total > 0 &&
                lastVisible >= total - 1 - loadMoreThreshold
            ) {
                onLoadMore?.invoke()
            }
        }
    }

    val headerHeightDp = with(density) { offsetPx.value.toDp() }

    LazyColumn(
        state = listState,
        modifier = modifier
            .fillMaxSize()
            .nestedScroll(connection),
        contentPadding = contentPadding
    ) {
        // Header
        item {
            if (headerHeightDp > 0.dp || isRefreshing) {
                val progress =
                    if (thresholdPx <= 0f) 0f else (offsetPx.value / thresholdPx).coerceIn(0f, 1.2f)

                val pullText =
                    pullToRefreshText.ifEmpty { stringResource(Res.string.default_pull_to_refresh) }
                val releaseText =
                    releaseToRefreshText.ifEmpty { stringResource(Res.string.default_release_to_refresh) }

                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(if (isRefreshing) thresholdDp.dp else headerHeightDp)
                ) {
                    if (isRefreshing) {
                        CommonProgressIndicator(
                            modifier = Modifier.align(Alignment.Center),
                        )
                    } else {
                        Column(
                            Modifier.align(Alignment.Center),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CommonProgressIndicator {
                                progress.coerceAtMost(1f)
                            }

                            if (isPullToRefreshTextVisible) {
                                AppSpace.VerticalSpace.Space4()

                                Text(
                                    text = if (progress >= 1f) releaseText else pullText,
                                    color = AppColors.Gray.LIGHT_SLATE,
                                    fontSize = AppTextSize.TEXT_SIZE_12
                                )
                            }
                        }
                    }
                }
            }
        }

        content()

        // Footer
        item {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                when {
                    isLoadingMore -> {
                        loadMoreFooter ?: run {
                            CommonProgressIndicator(
                                modifier = Modifier.padding(vertical = AppDimens.DIMEN_16)
                            )
                            loadMoreText?.let {
                                AppSpace.VerticalSpace.Space4()

                                Text(
                                    text = it,
                                    color = AppColors.Gray.LIGHT_SLATE,
                                    fontSize = AppTextSize.TEXT_SIZE_12
                                )
                            }
                        }
                    }

                    !hasMore -> {
                        endOfListFooter ?: noMoreContentText?.let {
                            Text(
                                text = it,
                                color = AppColors.Gray.LIGHT_SLATE,
                                fontSize = AppTextSize.TEXT_SIZE_12,
                                lineHeight = AppTextSize.TEXT_SIZE_16,
                                fontWeight = FontWeight.SemiBold,
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(vertical = AppDimens.DIMEN_12)
                                    .clickable(
                                        indication = null,
                                        interactionSource = remember { MutableInteractionSource() },
                                    ) {
                                        scope.launch {
                                            listState.animateScrollToItem(0)
                                        }
                                    },
                            )
                        }
                    }

                    else -> AppSpace.VerticalSpace.Space8()
                }
            }
        }
    }
}