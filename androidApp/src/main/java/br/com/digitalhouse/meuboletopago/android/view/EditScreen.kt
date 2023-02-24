package br.com.digitalhouse.meuboletopago.android.edit//package br.com.digitalhouse.meuboletopago.android.edit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.android.view.SignupScreen

@Composable
fun EditScreen(navController: NavController) {
    var state by remember { mutableStateOf(true) }
    var state2 by remember { mutableStateOf(true) }
    var state3 by remember { mutableStateOf(true) }
    MyApplicationTheme() {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TopAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    title = {
                        Text(text = "Edição")
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigate("home") }) {
                            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
                        }
                    },
                    contentColor = Color.White,
                    elevation = 8.dp
                )

                    LazyColumn(
                        modifier = Modifier.padding()
                    ) {
                        item {
                            Spacer(modifier = Modifier.height(20.dp))
                            Column (modifier = Modifier
                                .padding(25.dp)
                                .background(Color.White)
                                .fillMaxWidth()
                                .fillMaxHeight(),
                                horizontalAlignment = Alignment.Start,
                                verticalArrangement = Arrangement.Center){
                                val descricao = remember { mutableStateOf(TextFieldValue()) }
                                val valor = remember { mutableStateOf(TextFieldValue()) }
                                val data = remember { mutableStateOf(TextFieldValue()) }
                                Text(text = "Descrição", textAlign = TextAlign.Left,
                                    fontSize = 18.sp)
                                OutlinedTextField(
                                    modifier = Modifier.fillMaxWidth(),
                                    value = descricao.value,
                                    onValueChange = { descricao.value = it },
                                    label = { Text(text = "") }
                                )
                                Spacer(modifier = Modifier.height(20.dp))
                                Text(text = "Valor")
                                OutlinedTextField(
                                    modifier = Modifier.fillMaxWidth(),
                                    value = valor.value,
                                    onValueChange = { valor.value = it },
                                    label = { Text(text = "") }
                                )
                                Spacer(modifier = Modifier.height(20.dp))
                                Text(text = "Data")
                                OutlinedTextField(
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    value = data.value,
                                    onValueChange = { data.value = it },
                                    label = { Text(text = "") }
                                )
                            }
                            Spacer(modifier = Modifier.height(20.dp))
                            Button(
                                onClick = { navController.navigate("home")},
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
    }


@Preview
@Composable
fun EditPreview() {
    EditScreen(navController = NavController(LocalContext.current))

}