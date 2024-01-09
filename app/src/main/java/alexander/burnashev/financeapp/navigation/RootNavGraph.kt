package alexander.burnashev.financeapp.navigation

import alexander.burnashev.financeapp.screens.main.MainScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun RootNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        route = RootNavItem.Root.route,
        startDestination = RootNavItem.Main.route
    ) {

        composable(
            route = RootNavItem.Main.route
        ) {
            MainScreen()
        }
    }
}

sealed class RootNavItem(
    route: String,
) : NavItem(route) {
    data object Root : RootNavItem("root_graph")
    data object Main : RootNavItem("main_graph")
}