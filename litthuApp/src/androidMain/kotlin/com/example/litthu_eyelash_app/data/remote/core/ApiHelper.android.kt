package com.example.litthu_eyelash_app.data.remote.core

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp

actual fun provideHttpClientEngine(): HttpClientEngine {
    return OkHttp.create()
}