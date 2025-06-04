package com.example.litthu_eyelash_app.data.remote.core

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.plugins.HttpClientPlugin
import io.ktor.client.request.HttpRequestPipeline
import io.ktor.client.request.header
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.HttpResponsePipeline
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.util.AttributeKey

class CustomInterceptorConfig {
    var accessToken: String? = null
    var onUnauthorized: suspend () -> Unit = {}
}

class CustomInterceptor(
    private val accessToken: String? = null,
    private val onUnauthorized: suspend () -> Unit
) {
    companion object Plugin : HttpClientPlugin<CustomInterceptorConfig, CustomInterceptor> {
        override val key: AttributeKey<CustomInterceptor> = AttributeKey("CustomInterceptor")

        override fun prepare(block: CustomInterceptorConfig.() -> Unit): CustomInterceptor {
            val config = CustomInterceptorConfig().apply(block)
            return CustomInterceptor(config.accessToken, config.onUnauthorized)
        }

        override fun install(plugin: CustomInterceptor, scope: HttpClient) {
            // Before request
            scope.requestPipeline.intercept(HttpRequestPipeline.Before) {
                plugin.accessToken?.let { token ->
                    context.header("Authorization", "Bearer $token")
                }
                proceed()
            }

            // After response
            scope.responsePipeline.intercept(HttpResponsePipeline.Receive) { container ->
                val response = container.response
                if (response is HttpResponse && response.status == HttpStatusCode.Unauthorized) {
                    plugin.onUnauthorized()
                    throw UnauthorizedException("Unauthorized: ${response.bodyAsText()}")
                }
                proceed()
            }
        }
    }
}

class UnauthorizedException(message: String) : Exception(message)

fun HttpClientConfig<*>.installCustomInterceptor(configure: CustomInterceptorConfig.() -> Unit) {
    install(CustomInterceptor) {
        configure()
    }
}