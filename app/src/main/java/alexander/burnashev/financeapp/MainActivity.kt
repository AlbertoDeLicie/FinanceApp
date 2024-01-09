package alexander.burnashev.financeapp

import alexander.burnashev.financeapp.navigation.RootNavGraph
import alexander.burnashev.financeapp.ui.theme.FinanceAppShapes
import alexander.burnashev.financeapp.ui.theme.FinanceAppSizes
import alexander.burnashev.financeapp.ui.theme.FinanceAppTheme
import alexander.burnashev.financeapp.ui.theme.MainTheme
import alexander.burnashev.financeapp.ui.theme.baseDarkPalette
import alexander.burnashev.financeapp.ui.theme.baseLightPalette
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val systemUiController = rememberSystemUiController()

            val isDarkModeValue = true // isSystemInDarkTheme()

            val currentFontSize = remember { mutableStateOf(FinanceAppSizes.Medium) }
            val currentPaddingSize = remember { mutableStateOf(FinanceAppSizes.Medium) }
            val currentCornersStyle = remember { mutableStateOf(FinanceAppShapes.Rounded) }
            val isDarkMode = remember { mutableStateOf(isDarkModeValue) }

            MainTheme(
                darkTheme = isDarkMode.value,
                textSize = currentFontSize.value,
                corners = currentCornersStyle.value,
                paddingSize = currentPaddingSize.value
            ) {
                Surface (
                    color = FinanceAppTheme.colors.primaryBackground
                ){
                    SideEffect {
                        systemUiController.setSystemBarsColor(
                            color = if (isDarkMode.value) baseDarkPalette.primaryBackground else baseLightPalette.primaryBackground,
                            darkIcons = !isDarkMode.value
                        )
                    }

                    RootNavGraph(navController)
                }
            }
        }
    }
}
