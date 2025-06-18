package com.example.litthu_eyelash_app.data.local.di

import com.example.litthu_eyelash_app.data.local.non_volatile_memory.NonVolatileMemory
import com.example.litthu_eyelash_app.data.local.non_volatile_memory.NonVolatileMemoryImpl
import org.koin.dsl.module

val localDataModule = module {
    single<NonVolatileMemory> { NonVolatileMemoryImpl(settings = get()) }
}
