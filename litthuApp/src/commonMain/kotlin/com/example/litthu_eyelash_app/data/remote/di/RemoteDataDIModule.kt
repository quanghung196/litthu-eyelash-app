package com.example.litthu_eyelash_app.data.remote.di

import com.example.litthu_eyelash_app.data.remote.LitthuApiService
import com.example.litthu_eyelash_app.data.remote.LitthuApiServiceImpl
import com.example.litthu_eyelash_app.data.remote.LitthuNetworkProvider
import com.example.litthu_eyelash_app.data.remote.LitthuNetworkProviderImpl
import com.example.litthu_eyelash_app.data.remote.SafeCallApi
import org.koin.dsl.module

val remoteDataModule = module {
    single<LitthuNetworkProvider> {
        LitthuNetworkProviderImpl(
            nonVolatileMemory = get()
        )
    }
    single<LitthuApiService> {
        LitthuApiServiceImpl(
            networkProvider = get(),
        )
    }

    single<SafeCallApi> {
        SafeCallApi(
            authRepository = get(),
        )
    }
}