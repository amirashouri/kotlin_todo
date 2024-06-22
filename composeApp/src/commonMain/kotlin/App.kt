import androidx.compose.runtime.*
import app.TodoApp
import app.theme.TodoTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    TodoTheme {
        var showContent by remember { mutableStateOf(false) }
        val greeting = remember { Greeting().greet() }
        TodoApp()
    }
}