package features.todos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.theme.TodoTheme
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun TodosScreen(
    onNextButtonClicked: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Column(
            modifier = modifier.padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Welcome to my todos ...")
            Button(
                onClick = { onNextButtonClicked(1) },
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text("Add Todo")
            }
        }
    }
}

@Preview
@Composable
fun TodosScreenPreview() {
    TodoTheme {
        TodosScreen(
            onNextButtonClicked = {},
            modifier = Modifier.fillMaxHeight()
        )
    }
}