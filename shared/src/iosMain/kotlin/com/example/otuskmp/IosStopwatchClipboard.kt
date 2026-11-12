package com.example.otuskmp

import platform.UIKit.UIPasteboard

class IosStopwatchClipboard: StopwatchClipboard {
    override fun copyText(text: String) {
        UIPasteboard.generalPasteboard.string = text
    }
}