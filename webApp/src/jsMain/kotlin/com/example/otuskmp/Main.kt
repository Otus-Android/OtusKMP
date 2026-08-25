package com.example.otuskmp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import kotlinx.browser.window
import org.jetbrains.compose.web.attributes.ButtonType
import org.jetbrains.compose.web.attributes.type
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.borderRadius
import org.jetbrains.compose.web.css.bottom
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.fontSize
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.left
import org.jetbrains.compose.web.css.margin
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.right
import org.jetbrains.compose.web.css.top
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {
        StopwatchContent()
    }
}

@Composable
private fun StopwatchContent() {
    val viewModel = remember { StopwatchViewModel() }
    val uiState by viewModel.uiState.collectAsState()

    DisposableEffect(viewModel) {
        onDispose(viewModel::onDestroy)
    }

    Div(attrs = {
        style {
            position(Position.Absolute)
            top(0.px)
            right(0.px)
            bottom(0.px)
            left(0.px)
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            alignItems(AlignItems.Center)
            justifyContent(JustifyContent.Center)
            padding(24.px)
            property("box-sizing", "border-box")
            property("font-family", "system-ui, -apple-system, BlinkMacSystemFont, 'Segoe UI', sans-serif")
        }
    }) {
        H1(attrs = {
            style {
                margin(0.px)
                fontSize(2.cssRem)
                property("font-weight", "400")
                property("font-variant-numeric", "tabular-nums")
            }
        }) {
            Text(uiState.formattedTime)
        }
        Div(attrs = {
            style {
                display(DisplayStyle.Flex)
                marginTop(16.px)
                property("gap", "8px")
            }
        }) {
            Button(attrs = {
                type(ButtonType.Button)
                onClick { viewModel.onStartClicked() }
                style {
                    padding(10.px, 16.px)
                    borderRadius(999.px)
                    property("border", "0")
                    property("background", "transparent")
                    property("color", "#6750a4")
                    property("cursor", "pointer")
                    property("font", "inherit")
                    property("font-weight", "500")
                }
            }) {
                Text("Start")
            }
            Button(attrs = {
                type(ButtonType.Button)
                onClick { viewModel.onStopClicked() }
                style {
                    padding(10.px, 16.px)
                    borderRadius(999.px)
                    property("border", "0")
                    property("background", "transparent")
                    property("color", "#6750a4")
                    property("cursor", "pointer")
                    property("font", "inherit")
                    property("font-weight", "500")
                }
            }) {
                Text("Stop")
            }
            Button(attrs = {
                type(ButtonType.Button)
                onClick {
                    window.navigator.clipboard.writeText(uiState.formattedTime)
                }
                style {
                    padding(10.px, 16.px)
                    borderRadius(999.px)
                    property("border", "0")
                    property("background", "transparent")
                    property("color", "#6750a4")
                    property("cursor", "pointer")
                    property("font", "inherit")
                    property("font-weight", "500")
                }
            }) {
                Text("Copy")
            }
        }
    }
}
