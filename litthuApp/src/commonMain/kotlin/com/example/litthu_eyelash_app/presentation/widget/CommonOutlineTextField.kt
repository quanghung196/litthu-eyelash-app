package com.example.litthu_eyelash_app.presentation.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import com.example.litthu_eyelash_app.presentation.theme.AppColors
import com.example.litthu_eyelash_app.presentation.theme.AppDimens
import com.example.litthu_eyelash_app.presentation.theme.AppTextSize


@Composable
fun CommonOutlinedTextFieldWithLabel(
    label: String,
    value: String,
    hint: String,
    onValueChange: (String) -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onImeAction: (() -> Unit)? = null,
    onFocusChanged: (Boolean) -> Unit,
) {

    var isFocused by remember { mutableStateOf(false) }

    Column {
        Text(
            text = label,
            fontWeight = FontWeight.Medium,
            color = if (isFocused) AppColors.White.TRANSPARENT_80 else AppColors.White.TRANSPARENT_50,
            fontSize = AppTextSize.TEXT_SIZE_12,
            modifier = Modifier.fillMaxWidth()
        )

        CommonOutlinedTextField(
            value = value,
            hint = hint,
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { focusState ->
                    isFocused = focusState.isFocused
                    onFocusChanged.invoke(isFocused)
                },
            onValueChange = onValueChange,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            visualTransformation = visualTransformation,
            keyboardType = keyboardType,
            imeAction = imeAction,
            onImeAction = onImeAction,
        )
    }
}

@Composable
fun CommonOutlinedTextField(
    value: String,
    hint: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
    leadingIcon: @Composable (() -> Unit)?,
    trailingIcon: @Composable (() -> Unit)?,
    visualTransformation: VisualTransformation,
    keyboardType: KeyboardType,
    imeAction: ImeAction,
    onImeAction: (() -> Unit)?,
) {

    val keyboard = rememberKeyboardController()

    OutlinedTextField(
        value = value,
        placeholder = {
            Text(
                text = hint,
                color = AppColors.White.TRANSPARENT_80,
            )
        },
        modifier = modifier,
        colors = OutlinedTextFieldDefaults.colors(
            focusedTextColor = AppColors.White.PURE,
            unfocusedTextColor = AppColors.White.PURE,
            focusedBorderColor = AppColors.White.TRANSPARENT_80,
            unfocusedBorderColor = AppColors.White.TRANSPARENT_50,
            cursorColor = AppColors.White.PURE,
            focusedContainerColor = AppColors.White.TRANSPARENT_10,
            unfocusedContainerColor = AppColors.White.TRANSPARENT_05,
        ),
        shape = RoundedCornerShape(AppDimens.DIMEN_16),
        singleLine = true,
        onValueChange = onValueChange,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions(
            imeAction = imeAction,
            keyboardType = keyboardType,
        ),
        keyboardActions = KeyboardActions(
            onNext = { keyboard.moveFocus() },
            onDone = {
                keyboard.hideKeyboard()
                onImeAction?.invoke()
            }
        ),
    )
}