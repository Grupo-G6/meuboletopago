package br.com.digitalhouse.meuboletopago.android.view

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.android.login.LoginScreen


@Composable
fun CreateMovementScreen(navController: NavController)  {
    var state by remember { mutableStateOf(true) }
    var state2 by remember { mutableStateOf(true) }
    var state3 by remember { mutableStateOf(true) }
    val context = LocalContext.current
    val showDialog = remember { mutableStateOf(false) }
    MyApplicationTheme {
        Scaffold(
            topBar =   {  TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = {
                    Text(text = "Nova movimentação")
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("home") }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
                    }
                },
                contentColor = Color.White,
                elevation = 20.dp
            )
            }
        ) {
            LazyColumn(
                modifier = Modifier.padding(it)) {
                item {
                    Row(
                        Modifier.selectableGroup(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(modifier = Modifier.weight(1f))
                        RadioButton(
                            selected = state,
                            onClick = { state = true },
                            modifier = Modifier.semantics {
                                contentDescription = "Localized Description"
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xFF7BC59D),
                                unselectedColor = Color.LightGray
                            )

                        )
                        Text(text = "Receita")
                        Spacer(modifier = Modifier.weight(1f))
                        RadioButton(
                            selected = !state,
                            onClick = { state = false },
                            modifier = Modifier.semantics {
                                contentDescription = "Localized Description"
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xFF7BC59D),
                                unselectedColor = Color.LightGray
                            )
                        )
                        Text(
                            text = "Despesa",
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.weight(1f))
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Column (
                        modifier = Modifier
                            .padding(25.dp)
                            .background(Color.White)
                            .fillMaxWidth()
                            .fillMaxHeight(),

                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start){
                        val descricao = remember { mutableStateOf(TextFieldValue()) }
                        val valor = remember { mutableStateOf(TextFieldValue()) }
                        val data = remember { mutableStateOf(TextFieldValue()) }
                        Text(text = "Descrição")
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
                            modifier = Modifier.fillMaxWidth(),
                            value = data.value,
                            onValueChange = { data.value = it },
                            label = { Text(text = "") }
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        Modifier.selectableGroup(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(modifier = Modifier.weight(1f))
                        RadioButton(
                            selected = state2,
                            onClick = { state2 = true },
                            modifier = Modifier.semantics {
                                contentDescription = "Localized Description"
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xFF7BC59D),
                                unselectedColor = Color.LightGray
                            )

                        )
                        Text(text = "Não Repetir")
                        Spacer(modifier = Modifier.weight(1f))
                        RadioButton(
                            selected = !state2,
                            onClick = { state2 = false },
                            modifier = Modifier.semantics {
                                contentDescription = "Localized Description"
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xFF7BC59D),
                                unselectedColor = Color.LightGray
                            )
                        )
                        Text(
                            text = "Repetir",
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.weight(1f))
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Row(
                        Modifier.selectableGroup(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(modifier = Modifier.weight(1f))
                        RadioButton(
                            selected = state3,
                            onClick = { state3 = true },
                            modifier = Modifier.semantics {
                                contentDescription = "Localized Description"
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xFF7BC59D),
                                unselectedColor = Color.LightGray
                            )

                        )
                        Text(text = "Fixo")
                        Spacer(modifier = Modifier.weight(1f))
                        RadioButton(
                            selected = !state3,
                            onClick = { state3 = false },
                            modifier = Modifier.semantics {
                                contentDescription = "Localized Description"
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color(0xFF7BC59D),
                                unselectedColor = Color.LightGray
                            )
                        )
                        Text(
                            text = "Parcelado",
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.weight(1f))
                    }
                    Button(
                        onClick = {

                            navController.navigate("home")
                            Toast.makeText(context,
                                "Movimentação criada com sucesso!",
                                Toast.LENGTH_SHORT).show()

                            showDialog.value = !showDialog.value
              },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),

                        colors = ButtonDefaults.buttonColors(MaterialTheme.colors.primary)){
                        Text(text = "Salvar ",
                            color = Color.White)
                    }
                }
            }
        }
    }
}

