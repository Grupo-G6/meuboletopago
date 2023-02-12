package br.com.digitalhouse.meuboletopago.android.edit//package br.com.digitalhouse.meuboletopago.android.edit

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.android.components.TopBar

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EditScreen(navController: NavController)  {
    var state by remember { mutableStateOf(true) }
    var state2 by remember { mutableStateOf(true) }
    var state3 by remember { mutableStateOf(true) }
    MyApplicationTheme() {
        Scaffold (
            topBar = { TopBar(title = "Edição",navController = navController )}
        )  {
            LazyColumn(
                modifier = Modifier.padding(it)) {
                item {
                    Spacer(modifier = Modifier.height(20.dp))
                    Column{
                        val descricao = remember { mutableStateOf(TextFieldValue()) }
                        val valor = remember { mutableStateOf(TextFieldValue()) }
                        val data = remember { mutableStateOf(TextFieldValue()) }
                        Text(text = "Descrição")
                        TextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = descricao.value,
                            onValueChange = { descricao.value = it },
                            label = { Text(text = "") }
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(text = "Valor")
                        TextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = valor.value,
                            onValueChange = { valor.value = it },
                            label = { Text(text = "") }
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(text = "Data")
                        TextField(
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = data.value,
                            onValueChange = { data.value = it },
                            label = { Text(text = "") }
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = { navController.navigate("home") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(text = "Salvar")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun EditScreen_Preview(){}