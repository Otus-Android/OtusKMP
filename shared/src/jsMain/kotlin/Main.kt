import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.example.otuskmp.StopwatchViewModel
import kotlinx.browser.window
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {
        val viewModel = remember { StopwatchViewModel() }
        // Если collectAsState недоступен, можно написать свой простой коллектор
        val uiState by viewModel.uiState.collectAsState()

        Div {
            Text(uiState.formattedTime)
        }

        Div {
            Button(attrs = { onClick { viewModel.onStartClicked() } }) {
                Text("Start")
            }
            Button(attrs = { onClick { viewModel.onStopClicked() } }) {
                Text("Stop")
            }

            // Кнопка для Задания 2 (Копирование в JS)
            Button(attrs = {
                onClick {
                    window.navigator.clipboard.writeText(uiState.formattedTime)
                }
            }) {
                Text("Copy")
            }
        }
    }
}