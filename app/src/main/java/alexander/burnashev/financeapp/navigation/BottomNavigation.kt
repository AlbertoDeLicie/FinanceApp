package alexander.burnashev.financeapp.navigation

import alexander.burnashev.financeapp.navigation.routes.BottomNavItemRoutes
import alexander.burnashev.financeapp.ui.theme.FinanceAppTheme
import androidx.compose.foundation.background
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun BottomNavigationBar(
    navController: NavController,
) {
    val items = listOf(
        BottomNavItemRoutes.Money,
        BottomNavItemRoutes.AddPayment,
        BottomNavItemRoutes.Profile
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val previousDestination = remember { mutableStateOf(items.first().route) }

    BottomNavigation {
        items.forEach { item ->
            val isSelected = currentDestination?.hierarchy
                ?.any { it.route == item.route } == true

            BottomNavigationItem(
                modifier = Modifier
                    .background(FinanceAppTheme.colors.primaryBackground),
                selectedContentColor = FinanceAppTheme.colors.tintColor,
                unselectedContentColor = FinanceAppTheme.colors.controlColor,
                selected = isSelected,
                icon = {
                    Icon(
                        painterResource(id = item.icon),
                        contentDescription = null
                    )
                },
                label = {
                    Text(
                        stringResource(id = item.resourceId)
                    )
                },
                onClick = {
                    if (item.route == previousDestination.value) {
                        return@BottomNavigationItem
                    }
                    previousDestination.value = item.route
                    navController.navigate(item.route) {
                        println(navController.graph.findStartDestination())
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
