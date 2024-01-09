package alexander.burnashev.financeapp.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp

data class FinanceAppCommon(
    val elevation: Dp, val buttonWidth: Dp, val buttonHeight: Dp
)

data class FinanceAppColors(
    val primaryBackground: Color,
    val primaryText: Color,
    val secondaryBackground: Color,
    val secondaryText: Color,
    val tintColor: Color,
    val controlColor: Color,
    val indicatorColor: Color,
    val errorColor: Color,
)

data class FinanceAppTypography(
    val heading: TextStyle, val body: TextStyle, val toolbar: TextStyle, val caption: TextStyle
)

data class FinanceAppShape(
    val padding: Dp, val cornersStyle: Shape, val sheetShape: Shape
)

enum class FinanceAppSizes {
    Small, Medium, Big
}

enum class FinanceAppShapes {
    Flat, Rounded
}

object FinanceAppTheme {
    val common: FinanceAppCommon
        @Composable
        get() = LocalFinanceAppCommon.current

    val colors: FinanceAppColors
        @Composable
        get() = LocalFinanceAppColors.current

    val typography: FinanceAppTypography
        @Composable
        get() = LocalFinanceAppTypography.current

    val shapes: FinanceAppShape
        @Composable
        get() = LocalFinanceAppShape.current
}

val LocalFinanceAppColors = staticCompositionLocalOf<FinanceAppColors> {
    error("No FinanceAppColors provided")
}

val LocalFinanceAppCommon = staticCompositionLocalOf<FinanceAppCommon> {
    error("No FinanceAppCommon provided")
}

val LocalFinanceAppTypography = staticCompositionLocalOf<FinanceAppTypography> {
    error("No FinanceAppTypography provided")
}

val LocalFinanceAppShape = staticCompositionLocalOf<FinanceAppShape> {
    error("No FinanceAppShape provided")
}