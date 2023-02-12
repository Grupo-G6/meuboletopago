package br.com.digitalhouse.meuboletopago.android.movement

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.android.component.MaskTransformation
import br.com.digitalhouse.meuboletopago.android.component.TopBar

@Composable
fun MovementScreen(navController: NavController)  {
    val spacer: Dp = 16.dp
    var state by remember { mutableStateOf(true) }
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
                                unselectedColor = Color.LightGray,
                            )

                        )
                        Text(
                            text = "Receita",
                            color = (MaterialTheme.colors.primaryVariant)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        RadioButton(
                            selected = !state,
                            onClick = { state = false },
                            modifier = Modifier.semantics {
                                contentDescription = "Localized Description"
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color.Red,
                                unselectedColor = Color.LightGray
                            )
                        )
                        Text(
                            text = "Despesa",
                            color = (MaterialTheme.colors.primaryVariant)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                    }
                    Spacer(modifier = Modifier.height(spacer))
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(spacer)
                    ){
                        val descricao = remember { mutableStateOf(TextFieldValue()) }
                        val valor = remember { mutableStateOf(TextFieldValue()) }
                        val data = remember { mutableStateOf(TextFieldValue()) }
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = descricao.value,
                            onValueChange = { descricao.value = it },
                            label = { Text(text = "Descrição", color = (MaterialTheme.colors.primaryVariant)) }
                        )
                        Spacer(modifier = Modifier.height(spacer))
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = valor.value,
                            onValueChange = { valor.value = it },
                            label = {
                                Text(
                                    text = "Valor",
                                    color = (MaterialTheme.colors.primaryVariant)
                                )
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
                        )
                        Spacer(modifier = Modifier.height(spacer))
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = data.value,
                            onValueChange = { data.value = it },
                            label = {
                                Text(
                                    text = "Data",
                                    color = (MaterialTheme.colors.primaryVariant)
                                )
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            visualTransformation = MaskTransformation()
                        )
                    }
                    Spacer(modifier = Modifier.height(spacer))
                    Button(
                        onClick = { navController.navigate("home") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(spacer)
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
fun MovementScreen_Preview() {
    MovementScreen(navController = NavController(LocalContext.current))
}