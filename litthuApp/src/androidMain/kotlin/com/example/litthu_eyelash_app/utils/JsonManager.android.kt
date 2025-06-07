package com.example.litthu_eyelash_app.utils

actual fun readJsonFile(path: String): String {
    return ClassLoader.getSystemResourceAsStream(path)?.use {
        it.bufferedReader().readText()
    } ?: throw IllegalStateException("Cannot read file: $path")
}