package br.com.digitalhouse.meuboletopago.android.view

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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.android.movement.MovementViewModel
import br.com.digitalhouse.meuboletopago.model.Movement
import br.com.digitalhouse.meuboletopago.util.DataResult


@Composable
fun MovementScreen(navController: NavController)  {
    val viewModel = viewModel<MovementViewModel>()
    val movement by viewModel.movement.collectAsState()
    var state by remember { mutableStateOf(true) }
    val descricao = remember { mutableStateOf(TextFieldValue()) }
    val valor = remember { mutableStateOf(TextFieldValue()) }
    val data = remember { mutableStateOf(TextFieldValue()) }
    val isLogged = remember{ mutableStateOf(false)}

    MyApplicationTheme {
        Scaffold(
            topBar =   {  TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = {
                    Text(text = "Nova Movimentação")
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

//                        Text(text = "Descrição")
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = descricao.value,
                            onValueChange = { descricao.value = it },
                            label = { Text(text = "Descrição") }
                        )
                        Spacer(modifier = Modifier.height(20.dp))
//                        Text(text = "Valor")
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = valor.value,
                            onValueChange = { valor.value = it },
                            label = { Text(text = "Valor") }
                        )
                        Spacer(modifier = Modifier.height(20.dp))
//                        Text(text = "Data")
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = data.value,
                            onValueChange = { data.value = it },
                            label = { Text(text = "Data") }
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    if (movement is DataResult.Loading) {
                        CircularProgressIndicator()
                    } else {
                        if (movement is DataResult.Success && isLogged.value.not()) {
                            navController.navigate("home") /*todo redirecionar, apos criar, ele crasha)*/
                            isLogged.value = true
                        }
                        if (movement is DataResult.Error) {
                        Text(text = "O erro é: ${(movement as DataResult.Error).error.message}")
                        }
                    }

                    Button(
                        onClick = {
                            viewModel.postMovement(
                                movement = Movement(
                                    descriptionMovement = descricao.value.text,
                                    valueMovement = valor.value.text.toDouble(),
                                    dueDate = data.value.text,
                                    typeMovement = if (state) "1" else "2",
                                    seqParcel = 1,
                                    wasPaid = false
                                )
                            )
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

@Preview
@Composable
fun CreateMovementScreenPreview() {
    MovementScreen(navController = NavController(LocalContext.current))
}