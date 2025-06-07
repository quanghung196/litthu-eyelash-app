package com.example.litthu_eyelash_app.utils

import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSBundle
import platform.Foundation.NSString
import platform.Foundation.NSUTF8StringEncoding
import platform.Foundation.stringWithContentsOfFile

@OptIn(ExperimentalForeignApi::class)
actual fun readJsonFile(path: String): String {
    val fileName = path.removeSuffix(".json")
    return NSBundle.mainBundle.pathForResource(fileName, "json")?.let { filePath ->
        NSString.stringWithContentsOfFile(filePath, NSUTF8StringEncoding, null)
            ?: throw IllegalStateException("Failed to read content from file: $path")
    } ?: throw IllegalStateException("File not found: $path")
}