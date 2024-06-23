package features.todos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
    val state = rememberLazyListState(0)
    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn(
            state = state,
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,

            ) {
            items(50) {
                Text("Welcome to my todos ...")
            }
        }

        Button(
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(24.dp)
                .size(50.dp),
            shape = CircleShape,
            onClick = { onNextButtonClicked(0) }
        ) {
            Icon(Icons.Filled.Add, contentDescription = "Add todo")
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