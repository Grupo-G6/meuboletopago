package br.com.digitalhouse.meuboletopago.android

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColors(
            primary = Color(0xFF369B73),
            primaryVariant = Color.White,
            secondary =Color(0xFF1EB36A)
        )
    } else {
        lightColors(
            primary = Color(0xFF67FAA1),
            primaryVariant = Color(0xFF364B9B),
            secondary = Color(0xFF369B73),
        )
    }
    val nameMovementH5 = Typography(
        body1 = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Normal,
            fontSize = 24.sp
        )

    )

    val titleTopBarH6 = Typography(
        body1 = TextStyle(
            fontFamily = FontFamily.Monospace,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp
        )
    )
    val descriptionB1 = Typography(
        body1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colors = colors,
//        typography = typography,

        shapes = shapes,
        content = content
    )
}

//primary = Color(0xFFA1E2C8),
