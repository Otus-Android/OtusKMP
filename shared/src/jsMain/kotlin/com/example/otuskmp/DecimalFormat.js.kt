package com.example.otuskmp

actual class DecimalFormat actual constructor(private val pattern: String) {
    actual fun format(value: Double): String {
        val options = js("{}")

        val decimalPart = pattern.substringAfter('.', "")

        if (decimalPart.isNotEmpty()) {
            options.minimumFractionDigits = decimalPart.count { it == '0' }
            options.maximumFractionDigits = decimalPart.count {
                it == '0' || it == '#'
            }
        }

        options.useGrouping = pattern.contains(',')

        return js("new Intl.NumberFormat('en-US', options).format(value)")
    }
}