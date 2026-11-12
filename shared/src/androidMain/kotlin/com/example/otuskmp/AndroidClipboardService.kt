package com.example.otuskmp

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context

class AndroidStopwatchClipboard(context: Context) : StopwatchClipboard {
    private val appContext = context.applicationContext
    private val clipboardManager =
        appContext.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

    override fun copyText(text: String) {
        val clip = ClipData.newPlainText(
            "Stopwatch result",
            text
        )

        clipboardManager.setPrimaryClip(clip)
    }
}