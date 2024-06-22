package app

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import features.addTodo.AddTodoScreen
import features.todos.TodosScreen
import kotlin_todo.composeapp.generated.resources.Res
import kotlin_todo.composeapp.generated.resources.add_todo_screen
import kotlin_todo.composeapp.generated.resources.todos_screen
import org.jetbrains.compose.resources.StringResource

@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    innerPadding: PaddingValues,
) {
    NavHost(
        navController = navController,
        startDestination = AppRoute.LIST.name,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(innerPadding)
    ) {
        composable(route = AppRoute.LIST.name) {
            TodosScreen(modifier = Modifier.fillMaxHeight(), onNextButtonClicked = {
                navController.navigate(AppRoute.ADD_TODO.name)
            })
        }
        composable(route = AppRoute.ADD_TODO.name) {
            AddTodoScreen(modifier = Modifier.fillMaxHeight())
        }
    }
}

enum class AppRoute(val screen: StringResource) {
    LIST(screen = Res.string.todos_screen),
    ADD_TODO(screen = Res.string.add_todo_screen)
}