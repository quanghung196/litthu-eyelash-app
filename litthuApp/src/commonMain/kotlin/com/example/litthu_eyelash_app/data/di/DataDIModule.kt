package com.example.litthu_eyelash_app.data.di

import com.example.litthu_eyelash_app.data.local.di.localDataModule
import com.example.litthu_eyelash_app.data.remote.di.remoteDataModule
import com.example.litthu_eyelash_app.data.repository.di.repositoryModule
import org.koin.dsl.module

val dataModule = module {
    includes(
        localDataModule,
        repositoryModule,
        remoteDataModule,
    )
}