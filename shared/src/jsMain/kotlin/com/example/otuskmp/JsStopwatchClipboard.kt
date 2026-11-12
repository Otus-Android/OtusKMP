package com.example.otuskmp

import kotlinx.browser.window

class JsStopwatchClipboard: StopwatchClipboard {
    override fun copyText(text: String) {
        window.navigator.clipboard.writeText(text)
    }
}