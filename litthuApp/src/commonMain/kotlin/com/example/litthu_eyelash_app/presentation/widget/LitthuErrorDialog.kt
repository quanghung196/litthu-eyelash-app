package com.example.litthu_eyelash_app.presentation.widget

import androidx.compose.runtime.Composable
import com.example.litthu_eyelash_app.data.remote.LitthuErrorMessage
import com.example.litthu_eyelash_app.data.remote.LitthuNetworkError
import litthu_eyelash_app.litthuapp.generated.resources.F_LOGIN_001_message
import litthu_eyelash_app.litthuapp.generated.resources.F_LOGIN_001_title
import litthu_eyelash_app.litthuapp.generated.resources.F_LOGIN_002_message
import litthu_eyelash_app.litthuapp.generated.resources.F_LOGIN_002_title
import litthu_eyelash_app.litthuapp.generated.resources.Res
import litthu_eyelash_app.litthuapp.generated.resources.connection_timeout_error_message
import litthu_eyelash_app.litthuapp.generated.resources.connection_timeout_error_title
import litthu_eyelash_app.litthuapp.generated.resources.server_error_message
import litthu_eyelash_app.litthuapp.generated.resources.server_error_title
import litthu_eyelash_app.litthuapp.generated.resources.unauthorized_error_message
import litthu_eyelash_app.litthuapp.generated.resources.unknown_error_message
import litthu_eyelash_app.litthuapp.generated.resources.unknown_error_title
import org.jetbrains.compose.resources.stringResource

@Composable
fun LitthuErrorDialog(
    exception: Exception,
    onDismiss: () -> Unit,
    onRetry: () -> Unit,
) {
    val (messageTitle, messageDetail) = when (exception) {
        LitthuNetworkError.ServerErrorException -> {
            Pair(
                stringResource(Res.string.server_error_title),
                stringResource(Res.string.server_error_message),
            )
        }

        LitthuNetworkError.ConnectionTimeoutException -> {
            Pair(
                stringResource(Res.string.connection_timeout_error_title),
                stringResource(Res.string.connection_timeout_error_message),
            )
        }

        is LitthuNetworkError.LitthuErrorException -> {
            exception.toMessage()
        }

        LitthuNetworkError.UnauthorizedException -> {
            Pair(
                stringResource(Res.string.unknown_error_title),
                stringResource(Res.string.unauthorized_error_message),
            )
        }

        else -> {
            Pair(
                stringResource(Res.string.unknown_error_title),
                stringResource(Res.string.unknown_error_message),
            )
        }
    }
    CommonAlertDialog(
        messageTitle = messageTitle,
        messageDetail = messageDetail,
        onDismiss = onDismiss,
        onRetry = onRetry,
    )
}

@Composable
fun LitthuNetworkError.LitthuErrorException.toMessage(): Pair<String, String> {
    return when (errorResponse.messageID) {
        LitthuErrorMessage.F_LOGIN_001.name -> {
            Pair(
                stringResource(Res.string.F_LOGIN_001_title),
                stringResource(Res.string.F_LOGIN_001_message),
            )
        }

        LitthuErrorMessage.F_LOGIN_002.name -> {
            Pair(
                stringResource(Res.string.F_LOGIN_002_title),
                stringResource(Res.string.F_LOGIN_002_message),
            )
        }

        else -> {
            Pair(
                stringResource(Res.string.unknown_error_title),
                stringResource(Res.string.unknown_error_message),
            )
        }
    }
}