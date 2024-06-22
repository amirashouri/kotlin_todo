package app

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun TodoApp(navController: NavHostController = rememberNavController()) {
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentRoute = AppRoute.valueOf(
        backStackEntry?.destination?.route ?: AppRoute.LIST.name
    )

    Scaffold(
        topBar = {
            AppBar(
                currentRoute = currentRoute,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
            )
        }
    ) { innerPadding ->
        NavigationHost(
            modifier = Modifier,
            navController = navController,
            innerPadding = innerPadding,
        )
    }
}