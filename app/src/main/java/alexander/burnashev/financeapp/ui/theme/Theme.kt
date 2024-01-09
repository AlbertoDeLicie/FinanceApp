package alexander.burnashev.financeapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainTheme(
    textSize: FinanceAppSizes = FinanceAppSizes.Medium,
    paddingSize: FinanceAppSizes = FinanceAppSizes.Medium,
    corners: FinanceAppShapes = FinanceAppShapes.Rounded,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val common = FinanceAppCommon(
        elevation = 8.dp,
        buttonWidth = 200.dp,
        buttonHeight = 30.dp,
    )

    val colors = when (darkTheme) {
        true -> baseLightPalette
        false -> baseLightPalette
    }

    val typography = FinanceAppTypography(
        heading = TextStyle(
            fontSize = when (textSize) {
                FinanceAppSizes.Small -> 24.sp
                FinanceAppSizes.Medium -> 28.sp
                FinanceAppSizes.Big -> 32.sp
            },
            fontWeight = FontWeight.Bold
        ),
        body = TextStyle(
            fontSize = when (textSize) {
                FinanceAppSizes.Small -> 14.sp
                FinanceAppSizes.Medium -> 16.sp
                FinanceAppSizes.Big -> 18.sp
            },
            fontWeight = FontWeight.Normal
        ),
        toolbar = TextStyle(
            fontSize = when (textSize) {
                FinanceAppSizes.Small -> 14.sp
                FinanceAppSizes.Medium -> 16.sp
                FinanceAppSizes.Big -> 18.sp
            },
            fontWeight = FontWeight.Medium
        ),
        caption = TextStyle(
            fontSize = when (textSize) {
                FinanceAppSizes.Small -> 10.sp
                FinanceAppSizes.Medium -> 12.sp
                FinanceAppSizes.Big -> 14.sp
            }
        )
    )

    val shapes = FinanceAppShape(
        padding = when (paddingSize) {
            FinanceAppSizes.Small -> 12.dp
            FinanceAppSizes.Medium -> 16.dp
            FinanceAppSizes.Big -> 20.dp
        },
        cornersStyle = when (corners) {
            FinanceAppShapes.Flat -> RoundedCornerShape(0.dp)
            FinanceAppShapes.Rounded -> RoundedCornerShape(8.dp)
        },
        sheetShape = when(corners) {
            FinanceAppShapes.Rounded -> {
                RoundedCornerShape(
                    topStart = 8.dp,
                    topEnd = 8.dp,
                    bottomStart = 0.dp,
                    bottomEnd = 0.dp
                )
            }
            FinanceAppShapes.Flat -> {
                RoundedCornerShape(0.dp)
            }
        }
    )

    CompositionLocalProvider(
        LocalFinanceAppCommon provides common,
        LocalFinanceAppColors provides colors,
        LocalFinanceAppTypography provides typography,
        LocalFinanceAppShape provides shapes,
        content = content
    )
}