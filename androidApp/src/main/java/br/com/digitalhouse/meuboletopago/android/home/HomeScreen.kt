import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.android.R
import br.com.digitalhouse.meuboletopago.android.components.ListItemComponent
import br.com.digitalhouse.meuboletopago.android.home.HomeViewModel
import br.com.digitalhouse.meuboletopago.model.Movement
import br.com.digitalhouse.meuboletopago.model.User
import br.com.digitalhouse.meuboletopago.util.DataResult

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
    val viewModel = viewModel<HomeViewModel>()
    val transactions by viewModel.transactions.collectAsState()
    val user by viewModel.user.collectAsState()

    MyApplicationTheme {
        Scaffold(

            topBar = {
                TopAppBar(
                    title = { Text("Top App Bar") },
                    backgroundColor = MaterialTheme.colors.primary
                )
            },
            floatingActionButtonPosition = FabPosition.Center,
            floatingActionButton = {
                FloatingActionButton(onClick = {navController.navigate("movement_page")}) {
                    androidx.compose.material.Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "fab icon"
                    )
                }
            },

            content = {

//            ) {
                    Row() {
                        Column(
                           /* modifier = Modifier
                                .fillMaxWidth(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally*/) {


                            Text(

                                textAlign = TextAlign.End,
                                text = "Receitas:",
                                fontSize = 14.sp,
                                color = Color.Black,
                                modifier = Modifier.padding(8.dp, 0.dp),
                            )
                            Text(

                                textAlign = TextAlign.End,
                                text = " R$0.00",
                                fontSize = 14.sp,
                                color = Color.Black,
                                modifier = Modifier.padding(8.dp, 0.dp),
                            )
                            Spacer(modifier = Modifier.weight(1f))
                        }
                        Column() {
                            Text(
                                textAlign = TextAlign.Start,
                                text = "Despesas:",
                                fontSize = 14.sp,
                                color = Color.Black,
                                modifier = Modifier.padding(8.dp, 0.dp),
                            )

                            Text(

                                textAlign = TextAlign.Start,
                                text = " R$0.00",
                                fontSize = 14.sp,
                                color = Color.Black,
                                modifier = Modifier.padding(8.dp, 0.dp),
                            )
                        }

                        Spacer(modifier = Modifier.weight(1f))
                        Column()
                        {
                            Text(
                                textAlign = TextAlign.Center,
                                text = "Saldo:",
                                fontSize = 16.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(8.dp, 0.dp),
                            )
                            Text(
                                textAlign = TextAlign.Center,
                                text = "R$0.00",
                                fontSize = 16.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(8.dp, 0.dp),
                            )
//                            Spacer(modifier = Modifier.weight(1f))
                        }

                    }

                            run {

                            when (transactions) {
                                is DataResult.Loading -> LoadingIndicator()
                                is DataResult.Error -> ErrorMessage((transactions as DataResult.Error).error)
                                is DataResult.Success -> ContentHome(
                                    (transactions as DataResult.Success<List<Movement>>).data,
                                    user,
                                )
                                else -> Unit
                            }
                        }



            },
        )
    }
}

@Composable
fun ErrorMessage(error: Throwable) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Oooops! Algo deu errado ${error.message}")
    }
}

@Composable
fun LoadingIndicator() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(),
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ContentHome(
    movements: List<Movement>,
    profile: DataResult<User>,
) {
    LazyColumn (){
        item {
            if (profile is DataResult.Success) {
                Text(text = "Olá, ${profile.data.name}!")
            }
        }

        items(movements) { movement ->
            ListItemComponent(
               image = {
                   if (movement.typeMovement == "2") {

                   Image(
                       painter =  painterResource(R.drawable.barcode_fill0_wght400_grad0_opsz48),
                       contentDescription = "Profile Image",
                       contentScale = ContentScale.Fit,
                       modifier = Modifier
                           .height(56.dp)
                           .clip(CircleShape)
                           .background(Color.Red)
                           .padding(10.dp)
                           .clip(CircleShape)

                   ) }
                       else {
                       Image(
                           painter =  painterResource(R.drawable.payments_fill0_wght400_grad0_opsz48),
                           contentDescription = "Profile Image",
                           contentScale = ContentScale.Fit,
                           modifier = Modifier
                               .height(56.dp)
                               .clip(CircleShape)
                               .background(Color.Green)
                               .padding(10.dp)
                               .clip(CircleShape)

                       )}

                                                     },

                title = movement.descriptionMovement,


                subtitle =

                movement.typeMovement ?: "",


                    value = {
                    Text(text = "R$ ${movement.valueMovement}.")
                },
            )

        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = NavController(LocalContext.current))
}
/*todo
   -cards clicáveis;
    -edição, detalhamento e delete;
    -scroll e quantidade máxima de cards */