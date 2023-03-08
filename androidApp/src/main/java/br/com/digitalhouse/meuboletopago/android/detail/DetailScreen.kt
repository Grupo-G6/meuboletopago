package br.com.digitalhouse.meuboletopago.android.detail

import AlertDialogComponent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.android.components.LoadingIndicator
import br.com.digitalhouse.meuboletopago.android.components.cards.DetailCard
import br.com.digitalhouse.meuboletopago.model.Movement
import br.com.digitalhouse.meuboletopago.util.DataResult

@Composable
fun DetailScreen(navController: NavController, id: String?) {
    val viewModel = viewModel<DetailViewModel>()
    if (id != null) {
        viewModel.getMovementDetails(id)
    }
    val showDialog = remember { mutableStateOf(false) }
    val movement by viewModel.movement.collectAsState()

    MyApplicationTheme {
        Scaffold(
            topBar =   { TopAppBar(
                backgroundColor = MaterialTheme.colors.primaryVariant,
                title = { Text(
                    textAlign = TextAlign.Justify,
                    text = "Detalhes",
                    fontSize = 22.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,

                )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("home")}) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Voltar à tela principal")
                    }

                })
            }
        ) {
            when(movement) {
                is DataResult.Loading -> LoadingIndicator()
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
                    Column(
                        modifier = Modifier.padding(it),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically) {
                            DetailCard(description = (movement as DataResult.Success<Movement>).data.descriptionMovement,
                                dueDate = (movement as DataResult.Success<Movement>).data.dueDate,
                                valueMovement = "${(movement as DataResult.Success<Movement>).data.valueMovement}",
                                wasPaid = (movement as DataResult.Success<Movement>).data.wasPaid,
                                typeMovement = (movement as DataResult.Success<Movement>).data.typeMovement!!
                                )
                        }
                        Row(horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically) {
                            Button(modifier = Modifier.padding(16.dp),

                                onClick = {navController.navigate("edit_page/${(movement as DataResult.Success<Movement>).data.idMovement}")},
                                colors = ButtonDefaults.buttonColors(MaterialTheme.colors.primary)){
                                Text(text = "Editar",
                                    color = Color.White)
                            }
                            Button(modifier = Modifier.padding(16.dp),
                                onClick = {navController.navigate("delete_page/${(movement as DataResult.Success<Movement>).data.idMovement}") },
                                colors = ButtonDefaults.buttonColors(MaterialTheme.colors.primary)){
                                Text(text = "Excluir",
                                    color = Color.White)
                            }
                        }
                    }
                }
                else -> Unit
            }
        }
    }
}
