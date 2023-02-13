package br.com.digitalhouse.meuboletopago.android.movement

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.*
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
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.android.components.TopBar
import br.com.digitalhouse.meuboletopago.android.edit.EditScreen
import br.com.digitalhouse.meuboletopago.android.view.passwordMatches

class SignupScreen(navController: NavHostController) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(

                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background

                ) {
                    CreateMovementScreen(navController = NavController(LocalContext.current))
                }
            }
        }
    }
}




@Composable
fun CreateMovementScreen(navController: NavController)  {
    var state by remember { mutableStateOf(true) }
    var state2 by remember { mutableStateOf(true) }
    var state3 by remember { mutableStateOf(true) }
    val context = LocalContext.current
    val showDialog = remember { mutableStateOf(false) }
    MyApplicationTheme() {
        Scaffold (
            topBar = { TopBar(title = "Movimentação", navController = navController)}
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
                    Column {
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
                    Button(modifier = Modifier.padding(16.dp),
                        onClick = {

                            Toast.makeText(context,
                                "Movimentação criada com sucesso!",
                                Toast.LENGTH_SHORT).show()

                            showDialog.value = !showDialog.value
                            navController.navigate("home")
                        },

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
fun MovementScreen_Preview(){
     CreateMovementScreen(navController = NavController(LocalContext.current))
}