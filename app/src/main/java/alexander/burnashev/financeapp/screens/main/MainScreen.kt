package alexander.burnashev.financeapp.screens.main

import alexander.burnashev.financeapp.navigation.BottomNavigationBar
import alexander.burnashev.financeapp.navigation.routes.BottomNavItemRoutes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) {
        Box(
            modifier = Modifier
                .padding(bottom = it.calculateBottomPadding())
        ) {
            BottomNavigationTabContent(navController)
        }
    }
}

@Composable
fun BottomNavigationTabContent(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItemRoutes.Money.route
    ) {
        composable(BottomNavItemRoutes.Money.route) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = "Money"
                )
            }
        }

        composable(BottomNavItemRoutes.AddPayment.route) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = "Add payment"
                )
            }
        }

        composable(BottomNavItemRoutes.Profile.route) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = "Profile"
                )
            }
        }
    }
}