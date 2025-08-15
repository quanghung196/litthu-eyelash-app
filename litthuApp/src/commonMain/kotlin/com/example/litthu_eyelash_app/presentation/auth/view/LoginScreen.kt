package com.example.litthu_eyelash_app.presentation.auth.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import com.example.litthu_eyelash_app.presentation.auth.viewmodel.LoginViewModel
import com.example.litthu_eyelash_app.presentation.core.LoadingState
import com.example.litthu_eyelash_app.presentation.core.collectAsState
import com.example.litthu_eyelash_app.presentation.theme.AppColors
import com.example.litthu_eyelash_app.presentation.theme.AppDimens
import com.example.litthu_eyelash_app.presentation.theme.AppTextSize
import com.example.litthu_eyelash_app.presentation.widget.AppSpace
import com.example.litthu_eyelash_app.presentation.widget.AppSpace.ColumnSafeSpace
import com.example.litthu_eyelash_app.presentation.widget.CommonLoadingDialog
import com.example.litthu_eyelash_app.presentation.widget.CommonOutlinedTextFieldWithLabel
import com.example.litthu_eyelash_app.presentation.widget.LitthuErrorDialog
import com.example.litthu_eyelash_app.presentation.widget.rememberInject
import com.example.litthu_eyelash_app.presentation.widget.rememberKeyboardController
import litthu_eyelash_app.litthuapp.generated.resources.GreatVibes
import litthu_eyelash_app.litthuapp.generated.resources.Res
import litthu_eyelash_app.litthuapp.generated.resources.app_description
import litthu_eyelash_app.litthuapp.generated.resources.app_name
import litthu_eyelash_app.litthuapp.generated.resources.copyright
import litthu_eyelash_app.litthuapp.generated.resources.do_not_have_account
import litthu_eyelash_app.litthuapp.generated.resources.forgot_password
import litthu_eyelash_app.litthuapp.generated.resources.logging_in_dialog_message
import litthu_eyelash_app.litthuapp.generated.resources.logging_in_dialog_title
import litthu_eyelash_app.litthuapp.generated.resources.login
import litthu_eyelash_app.litthuapp.generated.resources.login_bg
import litthu_eyelash_app.litthuapp.generated.resources.password
import litthu_eyelash_app.litthuapp.generated.resources.password_hint
import litthu_eyelash_app.litthuapp.generated.resources.phone_number
import litthu_eyelash_app.litthuapp.generated.resources.phone_number_hint
import litthu_eyelash_app.litthuapp.generated.resources.signup
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun LoginScreenContent(
    onLoginSuccess: () -> Unit,
) {
    val keyboard = rememberKeyboardController()

    val viewModel = rememberInject<LoginViewModel>()
    val loadingState by viewModel.collectAsState { it.loadingState }
    val exception by viewModel.collectAsState { it.loginException }
    val isLoginSuccess by viewModel.collectAsState { it.isLoginSuccess }
    val userInfo by viewModel.collectAsState { it.userInfoDomainEntity }

    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }

    var emailFocused by remember { mutableStateOf(false) }
    var passwordFocused by remember { mutableStateOf(false) }

    fun checkIfAnyTextFieldInColumnIsFocused(): Boolean {
        return emailFocused || passwordFocused
    }

    fun validateLoginInput(): Boolean {
        return phoneNumber.isNotEmpty() && password.isNotEmpty()
    }

    fun login() {
        viewModel.login(
            phoneNumber = phoneNumber,
            password = password,
        )
    }

    LaunchedEffect(isLoginSuccess) {
        if (isLoginSuccess) {
            userInfo?.let {
                onLoginSuccess.invoke()
            }
        }
    }

    Image(
        painter = painterResource(
            resource = Res.drawable.login_bg,
        ),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.FillBounds,
    )

    ColumnSafeSpace(
        modifier = Modifier
            .pointerInput(Unit) {
                detectTapGestures {
                    if (checkIfAnyTextFieldInColumnIsFocused()) {
                        keyboard.hideKeyboard()
                    }
                }
            }
            .padding(AppDimens.DIMEN_24),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        AppSpace.VerticalSpace.Space60()

        Text(
            text = stringResource(Res.string.app_name),
            color = AppColors.Gray.DARK,
            fontSize = AppTextSize.TEXT_SIZE_40,
            letterSpacing = AppTextSize.TEXT_SIZE_2,
            fontFamily = FontFamily(Font(Res.font.GreatVibes)),
            fontWeight = FontWeight.SemiBold,
        )

        AppSpace.VerticalSpace.Space4()

        Text(
            text = stringResource(Res.string.app_description),
            fontSize = AppTextSize.TEXT_SIZE_14,
            fontWeight = FontWeight.SemiBold,
            color = AppColors.Gray.DARK,
            fontFamily = FontFamily(Font(Res.font.GreatVibes)),
            letterSpacing = AppTextSize.TEXT_SIZE_1,
        )

        AppSpace.VerticalSpace.Space24()

        CommonOutlinedTextFieldWithLabel(
            label = stringResource(Res.string.phone_number),
            value = phoneNumber,
            hint = stringResource(Res.string.phone_number_hint),
            onValueChange = { value ->
                phoneNumber = value
            },
            keyboardType = KeyboardType.Phone,
            onFocusChanged = { isFocus ->
                emailFocused = isFocus
            },
        )

        AppSpace.VerticalSpace.Space24()

        CommonOutlinedTextFieldWithLabel(
            label = stringResource(Res.string.password),
            value = password,
            hint = stringResource(Res.string.password_hint),
            onValueChange = { value ->
                password = value
            },
            trailingIcon = {
                IconButton(
                    onClick = { isPasswordVisible = !isPasswordVisible }
                ) {
                    Icon(
                        imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = null,
                        tint = if (passwordFocused) AppColors.White.TRANSPARENT_80 else AppColors.White.TRANSPARENT_50
                    )
                }
            },
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done,
            onImeAction = {
                if (validateLoginInput()) {
                    login()
                }
            },
            onFocusChanged = { isFocus ->
                passwordFocused = isFocus
            },
        )

        AppSpace.VerticalSpace.Space24()

        Button(
            onClick = {
                login()
            },
            enabled = validateLoginInput(),
            colors = ButtonDefaults.buttonColors(
                containerColor = AppColors.White.TRANSPARENT_90,
                contentColor = Color.DarkGray,
                disabledContainerColor = AppColors.White.TRANSPARENT_60
            ),
            shape = RoundedCornerShape(AppDimens.DIMEN_16),
            modifier = Modifier
                .fillMaxWidth()
                .height(AppDimens.DIMEN_48)
        ) {
            Text(
                text = stringResource(Res.string.login),
                fontWeight = FontWeight.SemiBold,
                fontSize = AppTextSize.TEXT_SIZE_16,
                letterSpacing = AppTextSize.TEXT_SIZE_1,
            )
        }

        AppSpace.VerticalSpace.Space20()

        Text(
            text = stringResource(Res.string.forgot_password),
            fontSize = AppTextSize.TEXT_SIZE_14,
            color = AppColors.White.TRANSPARENT_80,
            modifier = Modifier.clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
            ) {
                // TODO
            }
        )

        AppSpace.VerticalSpace.Space24()

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = stringResource(Res.string.do_not_have_account),
                fontSize = AppTextSize.TEXT_SIZE_12,
                color = AppColors.White.TRANSPARENT_70,
            )
            Text(
                text = stringResource(Res.string.signup),
                fontSize = AppTextSize.TEXT_SIZE_14,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                modifier = Modifier.clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                ) {
                    // TODO
                }
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            lineHeight = AppTextSize.TEXT_SIZE_16,
            text = stringResource(Res.string.copyright),
            fontSize = AppTextSize.TEXT_SIZE_12,
            color = AppColors.White.TRANSPARENT_80,
            textAlign = TextAlign.Center,
        )
    }

    if (loadingState == LoadingState.SHOW_LOADING) {
        CommonLoadingDialog(
            title = stringResource(Res.string.logging_in_dialog_title),
            message = stringResource(Res.string.logging_in_dialog_message),
        )
    }

    exception?.let {
        LitthuErrorDialog(
            exception = it,
            onDismiss = {
                viewModel.dispatchState { copy(loginException = null) }
            },
            onRetry = {
                login()
            },
        )
    }
}

