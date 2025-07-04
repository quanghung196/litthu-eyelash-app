package com.example.litthu_eyelash_app.presentation.main.view

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.litthu_eyelash_app.presentation.main.view.tab.VoyagerNavTab
import com.example.litthu_eyelash_app.presentation.theme.AppColors
import com.example.litthu_eyelash_app.presentation.theme.AppDimens
import com.example.litthu_eyelash_app.presentation.theme.AppTextSize
import com.example.litthu_eyelash_app.presentation.widget.AppSpace.ColumnSafeSpace

private const val NAVIGATION_BAR_ANIMATE_DURATION = 300

@Composable
fun CustomBottomNavigationLayout(
    tabNavigator: TabNavigator,
    tabs: List<VoyagerNavTab>,
) {
    ColumnSafeSpace {
        // Animated content transition
        AnimatedContent(
            modifier = Modifier.weight(1f),
            targetState = tabNavigator.current,
            transitionSpec = {
                val currentIndex = tabs.indexOfFirst { it == initialState }
                val targetIndex = tabs.indexOfFirst { it == targetState }

                if (targetIndex > currentIndex) {
                    // Slide left to right
                    slideInHorizontally(
                        initialOffsetX = { it },
                        animationSpec = tween(NAVIGATION_BAR_ANIMATE_DURATION)
                    ) + fadeIn(animationSpec = tween(NAVIGATION_BAR_ANIMATE_DURATION)) togetherWith
                            slideOutHorizontally(
                                targetOffsetX = { -it },
                                animationSpec = tween(NAVIGATION_BAR_ANIMATE_DURATION)
                            ) + fadeOut(animationSpec = tween(NAVIGATION_BAR_ANIMATE_DURATION))
                } else {
                    // Slide right to left
                    slideInHorizontally(
                        initialOffsetX = { -it },
                        animationSpec = tween(NAVIGATION_BAR_ANIMATE_DURATION)
                    ) + fadeIn(animationSpec = tween(NAVIGATION_BAR_ANIMATE_DURATION)) togetherWith
                            slideOutHorizontally(
                                targetOffsetX = { it },
                                animationSpec = tween(NAVIGATION_BAR_ANIMATE_DURATION)
                            ) + fadeOut(animationSpec = tween(NAVIGATION_BAR_ANIMATE_DURATION))
                }
            },
        ) { currentTab ->
            currentTab.Content()
        }
        // Custom bottom navigation
        Surface(
            shadowElevation = AppDimens.DIMEN_4,
        ) {
            VoyagerNavigationBar(
                tabNavigator = tabNavigator,
                tabs = tabs,
            )
        }
    }
}

@Composable
fun VoyagerNavigationBar(
    tabNavigator: TabNavigator,
    tabs: List<VoyagerNavTab>,
) {
    val backgroundBrush = Brush.verticalGradient(
        colors = listOf(
            AppColors.White.PURE,
            AppColors.Gray.LIGHT,
        )
    )

    Box(
        modifier = Modifier.background(backgroundBrush),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            tabs.forEach { navTab ->
                VoyagerNavItem(
                    tab = navTab,
                    isSelected = tabNavigator.current == navTab,
                    onClick = { tabNavigator.current = navTab },
                )
            }
        }
    }
}

@Composable
private fun VoyagerNavItem(
    tab: VoyagerNavTab,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    val scale by animateFloatAsState(
        targetValue = if (isSelected) 1.1f else 1.0f,
        animationSpec = tween(NAVIGATION_BAR_ANIMATE_DURATION),
    )

    val iconColor by animateColorAsState(
        targetValue = when {
            isSelected -> AppColors.Blue.PRIMARY_BLUE
            else -> AppColors.Gray.LIGHT_SLATE
        },
        animationSpec = tween(NAVIGATION_BAR_ANIMATE_DURATION),
    )

    Column(
        modifier = Modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { onClick.invoke() }
            .padding(all = AppDimens.DIMEN_8)
            .scale(scale),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Icon(
                imageVector = if (isSelected) {
                    tab.selectedIcon
                } else {
                    tab.icon
                },
                contentDescription = tab.options.title,
                tint = iconColor,
                modifier = Modifier.size(AppDimens.DIMEN_22)
            )

//            tab.badge?.let { badgeText ->
//                Badge(
//                    modifier = Modifier.align(Alignment.TopEnd).size(AppDimens.DIMEN_12),
//                    containerColor = NavigationBarColors.AccentOrange
//                ) {
//                    if (badgeText.isNotEmpty()) {
//                        Text(
//                            color = AppColors.White.PURE,
//                            text = badgeText,
//                            fontSize = AppTextSize.TEXT_SIZE_8,
//                            fontWeight = FontWeight.Bold,
//                        )
//                    }
//                }
//            }
        }

        Text(
            text = tab.options.title,
            color = iconColor,
            fontSize = AppTextSize.TEXT_SIZE_10,
            lineHeight = AppTextSize.TEXT_SIZE_16,
            fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}