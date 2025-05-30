package com.example.litthu_eyelash_app.data.remote.di

import com.example.litthu_eyelash_app.data.remote.LitthuApiService
import com.example.litthu_eyelash_app.data.remote.LitthuNetworkProvider
import com.example.litthu_eyelash_app.data.remote.LitthuNetworkProviderImpl
import org.koin.dsl.module

val remoteDataModule = module {
    single<LitthuNetworkProvider> { LitthuNetworkProviderImpl() }
    single<LitthuApiService> { LitthuApiService(get<LitthuNetworkProvider>().ktor) }
}