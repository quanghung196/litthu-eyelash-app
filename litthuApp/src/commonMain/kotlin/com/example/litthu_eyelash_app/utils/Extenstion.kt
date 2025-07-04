package com.example.litthu_eyelash_app.utils

fun Double.isNotNegative() = this >= 0.0

fun Any?.isNull() = this == null

fun Any?.isNotNull() = this != null

fun Int?.orDefault(default: Int = 0) = default

fun Double?.orDefault(default: Double = 0.0) = default

fun Boolean?.orDefault(default: Boolean = true) = default