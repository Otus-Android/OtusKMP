package com.example.otuskmp

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context

private var appContext: Context? = null

fun initializeClipboard(context: Context) {
    appContext = context.applicationContext
}

actual fun copyToClipboard(text: String) {
    val context = appContext ?: return
    val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as? ClipboardManager
    val clip = ClipData.newPlainText("Current time", text)
    clipboard?.setPrimaryClip(clip)
}
