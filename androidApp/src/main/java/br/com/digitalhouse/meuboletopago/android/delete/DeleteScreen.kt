package br.com.digitalhouse.meuboletopago.android.delete

import android.widget.Toast
import android.widget.Toast.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.android.component.TopBar

@Composable
fun DeleteScreen(navController: NavController) {
    val spacer: Dp = 16.dp
    val context = LocalContext.current
    MyApplicationTheme {
        Scaffold(
            topBar = { TopBar(title = "Exclusão", navController = navController) }
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(it)
                    .padding(spacer)
            ) {
                item{
                    Button(
                        onClick = {
                            Toast.makeText(
                                context,
                                "Registro excluído com sucesso!",
                                LENGTH_SHORT).show()
                            navController.navigate("home")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(spacer),
                    ){
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = ""
                        )
                        Text(text = "Excluir esse registro")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun DeleteScreen_Preview() {
    DeleteScreen(navController = NavController(LocalContext.current))
}