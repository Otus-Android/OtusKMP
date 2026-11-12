import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import org.jetbrains.compose.web.css.AlignItems
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.alignItems
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.flexDirection
import org.jetbrains.compose.web.css.gap
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable
import com.example.otuskmp.StopwatchViewModel
import org.jetbrains.compose.web.css.FlexDirection

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    renderComposable(rootElementId = "root") {
        StopWatchContent()
    }
}

@Composable
fun StopWatchContent() {
    val viewModel = remember { StopwatchViewModel() }
    val uiState by viewModel.uiState.collectAsState()

    DisposableEffect(viewModel) {
        onDispose {
            viewModel.onDestroy()
        }
    }

    Div(
        attrs = {
            style {
                display(DisplayStyle.Flex)
                flexDirection(FlexDirection.Column)
                justifyContent(JustifyContent.Center)
                alignItems(AlignItems.Center)
                padding(16.px)
                gap(16.px)
            }
        }
    ) {
        Div {
            Text(uiState.formattedTime)
        }

        Div(
            attrs = {
                style {
                    display(DisplayStyle.Flex)
                    flexDirection(FlexDirection.Row)
                    gap(8.px)
                }
            }
        ) {
            Button(
                attrs = {
                    onClick { viewModel.onStartClicked() }
                }
            ) {
                Text("Start")
            }

            Button(
                attrs = {
                    onClick { viewModel.onStopClicked() }
                }
            ) {
                Text("Stop")
            }
        }
    }
}