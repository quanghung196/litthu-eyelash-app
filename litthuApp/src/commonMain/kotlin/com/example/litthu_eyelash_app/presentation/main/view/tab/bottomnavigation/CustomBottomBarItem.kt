package com.example.litthu_eyelash_app.presentation.main.view.tab.bottomnavigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import com.example.litthu_eyelash_app.presentation.main.view.tab.VoyagerNavTab
import com.example.litthu_eyelash_app.presentation.theme.AppColors
import com.example.litthu_eyelash_app.presentation.theme.AppDimens
import com.example.litthu_eyelash_app.presentation.widget.AppSpace
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow


@Composable
fun RowScope.CustomBottomBarItem(tab: VoyagerNavTab) {
    val tabNavigator = LocalTabNavigator.current
    val isSelected = tabNavigator.current == tab

    Column(
        modifier = Modifier
            .weight(1f)
            .clickable(
                interactionSource = remember { NoRippleInteractionSource() },
                indication = null
            ) {
                tabNavigator.current = tab
            }
            .padding(vertical = AppDimens.DIMEN_8),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = if (isSelected) tab.selectedIcon else tab.icon,
            contentDescription = tab.options.title,
            tint = if (isSelected) AppColors.Gray.MID_NIGHT_SLATE else AppColors.Gray.LIGHT_SLATE,
            modifier = Modifier.size(AppDimens.DIMEN_28)
        )

        AppSpace.VerticalSpace.Space2()

        Text(
            text = tab.options.title,
            color = if (isSelected) AppColors.Gray.MID_NIGHT_SLATE else AppColors.Gray.LIGHT_SLATE,
            style = MaterialTheme.typography.labelMedium,
            maxLines = 1
        )
    }
}

class NoRippleInteractionSource : MutableInteractionSource {
    override val interactions: Flow<Interaction> = emptyFlow()
    override suspend fun emit(interaction: Interaction) {}
    override fun tryEmit(interaction: Interaction) = true
}