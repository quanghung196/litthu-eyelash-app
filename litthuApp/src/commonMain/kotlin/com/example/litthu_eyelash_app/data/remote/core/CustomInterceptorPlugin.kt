package com.example.litthu_eyelash_app.data.remote.core

import com.example.litthu_eyelash_app.data.model.BaseResponseEntity
import com.example.litthu_eyelash_app.data.remote.LitthuNetworkError
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.network.sockets.ConnectTimeoutException
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.plugins.HttpClientPlugin
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.HttpRequestPipeline
import io.ktor.client.request.header
import io.ktor.client.statement.HttpResponsePipeline
import io.ktor.http.HttpStatusCode
import io.ktor.util.AttributeKey

class CustomInterceptorConfig {
    var accessToken: String? = null
}

class CustomInterceptor(
    private val accessToken: String? = null,
) {
    companion object Plugin : HttpClientPlugin<CustomInterceptorConfig, CustomInterceptor> {
        private const val AUTHORIZATION_KEY = "Authorization"
        private const val AUTHORIZATION_VALUE_PREFIX = "Bearer"

        private const val ATTRIBUTE_KEY = "CustomInterceptor"

        private const val RESULT_OK = "OK"

        override val key: AttributeKey<CustomInterceptor> = AttributeKey(ATTRIBUTE_KEY)

        override fun prepare(block: CustomInterceptorConfig.() -> Unit): CustomInterceptor {
            val config = CustomInterceptorConfig().apply(block)
            return CustomInterceptor(config.accessToken)
        }

        override fun install(plugin: CustomInterceptor, scope: HttpClient) {
            // Before request
            scope.requestPipeline.intercept(HttpRequestPipeline.Before) {
                try {
                    plugin.accessToken?.let { token ->
                        context.header(AUTHORIZATION_KEY, "$AUTHORIZATION_VALUE_PREFIX $token")
                    }
                    proceed()
                } catch (e: Exception) {
                    throw when (e) {
                        is HttpRequestTimeoutException,
                        is SocketTimeoutException,
                        is ConnectTimeoutException -> {
                            LitthuNetworkError.ConnectionTimeoutException
                        }

                        else -> {
                            LitthuNetworkError.UnknownException
                        }
                    }
                }
            }

            // After response
            scope.responsePipeline.intercept(HttpResponsePipeline.Transform) { (_, body) ->
                val httpResponse = context.response
                if (httpResponse.status == HttpStatusCode.OK &&
                    body is BaseResponseEntity &&
                    body.result != RESULT_OK
                ) {
                    throw LitthuNetworkError.LitthuErrorException(
                        errorResponse = body
                    )
                }
                try {
                    proceed()
                } catch (e: Exception) {
                    throw when (e) {
                        is HttpRequestTimeoutException,
                        is SocketTimeoutException,
                        is ConnectTimeoutException -> {
                            LitthuNetworkError.ConnectionTimeoutException
                        }

                        is ServerResponseException -> {
                            LitthuNetworkError.ServerErrorException
                        }

                        else -> {
                            LitthuNetworkError.UnknownException
                        }
                    }
                }
            }
        }
    }
}

fun HttpClientConfig<*>.installCustomInterceptor(configure: CustomInterceptorConfig.() -> Unit) {
    install(CustomInterceptor) {
        configure()
    }
}