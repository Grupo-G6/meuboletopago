package br.com.digitalhouse.meuboletopago.android.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.android.components.cards.DetailCard

@Composable
fun DetailScreen(navController: NavController) {
    MyApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                TopAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    title = {
                        Text(text = "Detalhes")
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigate("home") }) {
                            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
                        }
                    },
                    contentColor = Color.White,
                    elevation = 8.dp
                )

                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {
                    DetailCard(description = "Academia",
                        dueDate = "03/02/2023",
                        valueMovement = "110,00")
                }

                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {
                    Button(modifier = Modifier.padding(16.dp),
                        onClick = {navController.navigate("edit_page")},
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colors.primary)){
                        Text(text = "Editar",
                            color = Color.White)
                    }
                    Button(modifier = Modifier.padding(16.dp),
                        onClick = {navController.navigate("delete_page") },
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colors.primary)){
                        Text(text = "Excluir",
                            color = Color.White)
                    }

                }
                Button(modifier = Modifier.padding(16.dp),
                    onClick = {navController.navigate("home") },
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colors.primary)){
                    Text(text = "Salvar",
                        color = Color.White)
                }

            }
        }
    }
}
