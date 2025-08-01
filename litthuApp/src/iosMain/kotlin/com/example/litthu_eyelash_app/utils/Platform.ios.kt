package com.example.litthu_eyelash_app.utils

import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    override val osType: OSType = OSType.IOS
}

actual fun getPlatform(): Platform = IOSPlatform()