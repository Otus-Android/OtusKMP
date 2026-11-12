package com.example.otuskmp

actual fun currentTimeMillis(): Long {
    return js("Date.now()").unsafeCast<Double>().toLong()
}