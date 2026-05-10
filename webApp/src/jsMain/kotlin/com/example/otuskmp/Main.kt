package com.example.otuskmp

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable

fun main() {
    val viewModel = StopwatchViewModel()
    renderComposable(rootElementId = "root") {
        val uiState by viewModel.uiState.collectAsState()
        Div({
            style {
                padding(16.px)
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column)
                alignItems(AlignItems.Center)
            }
        }) {
            H2 {
                Text(uiState.formattedTime)
            }
            Div({
                style {
                    display(DisplayStyle.Flex)
                    gap(8.px)
                }
            }) {
                Button(attrs = {
                    onClick { viewModel.onStartClicked() }
                }) {
                    Text("Start")
                }
                Button(attrs = {
                    onClick { viewModel.onStopClicked() }
                }) {
                    Text("Stop")
                }
                Button(attrs = {
                    onClick { viewModel.onCopyClicked() }
                }) {
                    Text("Copy")
                }
            }
        }
    }
}
