import AlertDialogComponent
import android.annotation.SuppressLint
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
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.android.components.LoadingIndicator
import br.com.digitalhouse.meuboletopago.android.components.TopBar
import br.com.digitalhouse.meuboletopago.model.Movement
import br.com.digitalhouse.meuboletopago.util.DataResult


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EditScreen(navController: NavController, id: String?) {
    val viewModel = viewModel<EditViewModel>()
    if (id != null) {
        viewModel.getMovementDetails(id)
    }
    val showDialog = remember { mutableStateOf(false) }
    val movement by viewModel.movement.collectAsState()
    val changedState by viewModel.changedState.collectAsState()

    var descricao = remember { mutableStateOf(TextFieldValue()) }
    var valor = remember { mutableStateOf(TextFieldValue()) }
    var data = remember { mutableStateOf(TextFieldValue()) }
    var state by remember { mutableStateOf(true) }
    var state2 by remember { mutableStateOf(false) }
    MyApplicationTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    title = {
                        Text(text = "Editar Movimentação")
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigate("home") }) {
                            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
                            viewModel.setDefaultState()
                        }
                    },
                    contentColor = Color.White,
                    elevation = 20.dp,
                )
            },
        ){

            when(movement) {
                is DataResult.Loading -> CircularProgressIndicator()
                is DataResult.Error -> {
                    AlertDialogComponent(
                        showDialog = showDialog.value,
                        message = "Ocorreu um erro inesperado, tente novamente!",
                        onDismissRequest = {
                            showDialog.value = !showDialog.value
                            navController.navigate("home")
                        }
                    )
                }
                is DataResult.Success -> {
//                    if (changedState is DataResult.Loading) {
//                        CircularProgressIndicator()
//                    } else {
//                        if (changedState is DataResult.Success ) {
//                            navController.navigate("home")
//                            viewModel.setDefaultState()
//                        }
//                        if (changedState is DataResult.Error) {
//                            Text(text = "O erro é: ${(changedState as DataResult.Error).error.message}")
//                        }
//                    }
                    LazyColumn(
                        modifier = Modifier.padding()
                    ) {
                        descricao.value =
                            TextFieldValue(
                                (movement as DataResult.Success<Movement>).data.descriptionMovement
                            )
                        valor.value =
                            TextFieldValue(
                                (movement as DataResult.Success<Movement>).data.valueMovement.toString()
                            )
                        data.value =
                            TextFieldValue(
                                (movement as DataResult.Success<Movement>).data.dueDate
                            )
                        item {
                            Row(
                                Modifier.selectableGroup(),
                                verticalAlignment = Alignment.CenterVertically,
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
                                    ),

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
                                        selectedColor = Color.Red,
                                        unselectedColor = Color.LightGray,
                                    ),
                                )
                                Text(
                                    text = "Despesa",
                                    textAlign = TextAlign.Center,
                                )
                                Spacer(modifier = Modifier.weight(1f))
                            }
                            Column(
                                modifier = Modifier
                                    .padding(25.dp)
                                    .background(Color.White)
                                    .fillMaxWidth()
                                    .fillMaxHeight(),
                                horizontalAlignment = Alignment.Start,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Spacer(modifier = Modifier.height(20.dp))
                                Text(text = "Descrição")
                                TextField(
                                    modifier = Modifier.fillMaxWidth(),
                                    value = descricao.value,
                                    onValueChange = { descricao.value = it },
                                    label = {Text(text = descricao.value.text) }

                                )
                                Spacer(modifier = Modifier.height(20.dp))
                                Text(text = "Valor")
                                TextField(
                                    modifier = Modifier.fillMaxWidth(),
                                    value = valor.value,
                                    onValueChange = { valor.value = it },
                                    label = {Text(text = valor.value.text) }

                                )
                                Spacer(modifier = Modifier.height(20.dp))
                                Text(text = "Data")
                                TextField(
                                    modifier = Modifier.fillMaxWidth(),
                                    value = data.value,
                                    onValueChange = { data.value = it },
                                    label = {Text(text = data.value.text) }

                                )

                            }
                            Row(
                                Modifier.selectableGroup(),
                                verticalAlignment = Alignment.CenterVertically,
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
                                        unselectedColor = Color.LightGray,
                                    ),

                                    )
                                Text(text = "Pago")
                                Spacer(modifier = Modifier.weight(1f))
                                RadioButton(
                                    selected = !state2,
                                    onClick = { state2 = false },
                                    modifier = Modifier.semantics {
                                        contentDescription = "Localized Description"
                                    },
                                    colors = RadioButtonDefaults.colors(
                                        selectedColor = Color.Red,
                                        unselectedColor = Color.LightGray,
                                    ),
                                )
                                Text(
                                    text = "Não Pago",
                                    textAlign = TextAlign.Center,
                                )
                                Spacer(modifier = Modifier.weight(1f))
                            }

                            Button(
                                onClick = {
                                    viewModel.editMovement(
                                        id = (movement as DataResult.Success<Movement>).data.idMovement.toString(),
                                        movement = Movement(
                                            descriptionMovement = descricao.value.text,
                                            valueMovement = valor.value.text.toDouble(),
                                            dueDate = data.value.text,
                                            typeMovement = if (state) "1" else "2",
                                            seqParcel = 1,
                                            wasPaid = state2,
                                        ),
                                        navController = navController
                                    )
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(text = "Salvar")
                            }
                        }
                    }
                }
                else -> Unit
            }
        }
    }
}


@Preview
@Composable
fun EditPreview() {
    EditScreen(navController = NavController(LocalContext.current), id = "1")

}