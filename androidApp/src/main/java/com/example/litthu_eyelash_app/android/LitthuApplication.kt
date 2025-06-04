package com.example.litthu_eyelash_app.android

import android.app.Application
import com.example.litthu_eyelash_app.di.initKoin
import org.koin.android.ext.koin.androidContext

class LitthuApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@LitthuApplication)
        }
    }
}