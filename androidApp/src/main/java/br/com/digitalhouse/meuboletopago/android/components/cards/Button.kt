package br.com.digitalhouse.meuboletopago.android.components.cards

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Button(): Unit {
    OutlinedButton(
        onClick = { },
        border = BorderStroke(1.dp, Color(0xFF369B73)),
        modifier = Modifier.width(220.dp),
//                    shape = RoundedCornerShape(50), // = 50% percent
        shape = CircleShape,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color(0xFFA1E2C8),
            containerColor = Color(0xFF369B73)
        )
    ) {
        Text(text = "Save")
    }
}