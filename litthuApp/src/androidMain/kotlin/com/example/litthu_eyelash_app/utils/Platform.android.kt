package com.example.litthu_eyelash_app.utils

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
    override val osType: OSType = OSType.ANDROID
}

actual fun getPlatform(): Platform = AndroidPlatform()