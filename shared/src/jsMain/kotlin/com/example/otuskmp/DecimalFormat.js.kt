package com.example.otuskmp

actual class DecimalFormat actual constructor(pattern: String) {
    private val fractionDigits = pattern.substringAfter('.', "").length

    actual fun format(value: Double): String =
        value.asDynamic().toFixed(fractionDigits) as String
}
