package br.com.digitalhouse.meuboletopago.android.components.cards

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.style.TextDirection.Companion.Content
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.ButtonColors as ButtonColors1


@Composable
fun ButtonSmall(textToast: String, navController: NavController, route: String, textButton: String) {
    val buttonSize = 260.dp
    val ctx = LocalContext.current
    val showDialog = remember { mutableStateOf(false) }
    Button(
        onClick = {
            Toast.makeText(ctx, textToast, Toast.LENGTH_SHORT).show()
            navController.navigate(route)

        },
        modifier = Modifier.width(buttonSize),


    )
    /*TODO MUDAR COR E FORMATO DO BOTÃO*/


    {
    Text( text = textButton)

    }
}

