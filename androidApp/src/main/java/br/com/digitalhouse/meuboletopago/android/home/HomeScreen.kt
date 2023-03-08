import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.android.R
import br.com.digitalhouse.meuboletopago.android.components.ListItemComponent
import br.com.digitalhouse.meuboletopago.android.components.cards.Balance
import br.com.digitalhouse.meuboletopago.android.home.HomeViewModel
import br.com.digitalhouse.meuboletopago.model.Balance
import br.com.digitalhouse.meuboletopago.model.Movement
import br.com.digitalhouse.meuboletopago.model.User
import br.com.digitalhouse.meuboletopago.util.DataResult

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController) {
//    val preferences: SharedPreferences =
//        PreferenceManager.getDefaultSharedPreferences(LocalContext.current)
    val viewModel = viewModel<HomeViewModel>()
    val transactions by viewModel.transactions.collectAsState()
    val user by viewModel.user.collectAsState()

    val balance by viewModel.balance.collectAsState()
    val preferences: SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(LocalContext.current)
    val idUser =  preferences.getInt("idUser", 0).toString()
    val isLogged = remember { mutableStateOf(false) }
        if (isLogged.value.not()){
            viewModel.getAll()
            viewModel.getUser(idUser)
            viewModel.getBalance()
            isLogged.value = true

        }
//    (navController = navController,


    MyApplicationTheme {
        Scaffold(



            topBar = {
                TopAppBar(


                    title =
                    {
//
                        if (user is DataResult.Success )
                            Text(text = " Olá  ${(user as DataResult.Success<User>).data.name}! :)", color = Color.White)

                    },
                    backgroundColor = MaterialTheme.colors.primaryVariant
                )

            },
            floatingActionButtonPosition = FabPosition.Center,


            floatingActionButton = {
                FloatingActionButton(onClick = {navController.navigate("movement_page")}, contentColor = MaterialTheme.colors.primaryVariant, backgroundColor = MaterialTheme.colors.primary ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "fab icon")
                }

            },


            content = {

                            run {

                            when (transactions) {
                                is DataResult.Loading -> LoadingIndicator()
                                is DataResult.Error -> ErrorMessage((transactions as DataResult.Error).error)
                                is DataResult.Success -> ContentHome(
                                    (transactions as DataResult.Success<List<Movement>>).data,
                                    user, navController, balance
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
    navController: NavController,
    balance: DataResult<Balance>,
) {
    LazyColumn() {
        item {

            Balance(navController = NavController(LocalContext.current), balance)
        }
//        title = movement.descriptionMovement,

        items(movements) { movement ->
            ListItemComponent(


                image = {
                    if (movement.typeMovement == "2") {


                        Image(
                            painter = painterResource(R.drawable.barcode_fill0_wght400_grad0_opsz48),
                            contentDescription = "Profile Image",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .height(46.dp)
                                .width(46.dp)
                                .clip(CircleShape)
                                .background(Color(0x1CFD3C72))
                                .padding(10.dp)
//                           .border(3.dp, shape = RoundedCornerShape(3.dp), color = Color.Transparent)
//                           .clickable { navController.navigate("detail_page")}


                        )
//                       Text(text = "despesa")
                    } else {
                        Image(
                            painter = painterResource(R.drawable.monetization_on_black_24dp),
                            contentDescription = "Profile Image",
                            contentScale = ContentScale.Fit,
                            modifier = Modifier
                                .height(46.dp)
                                .width(46.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFC8E7C9))
                                .padding(5.dp)
//                               .border(1.dp, color = Color.DarkGray)
//                               .border(3.dp, shape = RoundedCornerShape(5.dp), color = Color.Transparent)
//                               .border(3.dp, shape = RoundedCornerShape(3.dp), color = Color.Transparent)


                        )

//                   Text(text = "receita")

                    }
                },

                title = movement.descriptionMovement,

//
//                title = "Dribble Inc" ,
//                subtitle =  "Crédito",
//                value = {
//                    Text(text = "+ R$ 45", color = Color.Green, fontWeight =
//                    FontWeight. Bold, fontSize =  20.sp)

//                subtitle = {
//                    if (movement.typeMovement == "2") {
//                        Text(text = "receita")
//                    } else {
//                        Text(text = "receita")
//
//                    }
//

//                },
                      subtitle = ""  ,

//
//                movement.typeMovement ?: "",

//                subtitle = {
//                    if (movement.typeMovement == "2") {
//                        Text(
//                            text = "R$ ${movement.valueMovement}",
//                            fontWeight = FontWeight.Bold,
//                            color = Color(0xFFC03C33),
//                            fontSize = 20.sp
//                        )
//                    } else {
//
//                        Text(
//                            text = "R$ ${movement.valueMovement}",
//                            fontWeight = FontWeight.Bold,
//                            color = Color(0xFF4CAF50),
//                            fontSize = 20.sp
//                        )
//                    }
//
//                },


                value = {
                    if (movement.typeMovement == "2") {
                        Text(
                            text = "- R$ ${movement.valueMovement}",
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFC03C33),
                            fontSize = 16.sp
                        )
                    } else {

                        Text(
                            text = "+ R$ ${movement.valueMovement}",
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF4CAF50),
                            fontSize = 16.sp
                        )
                    }

                },

                onDetailNavigate = {
                    navController.navigate("detail_page/${movement.idMovement}")

                }
            )

        }
    }
}


//@Preview
//@Composable
//fun HomeScreenPreview() {
//    HomeScreen(navController = NavController(LocalContext.current), contexto: Context)
//}


