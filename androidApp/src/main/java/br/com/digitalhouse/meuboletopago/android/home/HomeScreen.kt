import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.navigation.compose.rememberNavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.android.R
import br.com.digitalhouse.meuboletopago.android.components.ListItemComponent
import br.com.digitalhouse.meuboletopago.android.components.cards.Balance
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
                    title = { Text("Olá, ") },
                    backgroundColor = MaterialTheme.colors.primary
                )

            },
            floatingActionButtonPosition = FabPosition.Center,


            floatingActionButton = {
                FloatingActionButton(onClick = {navController.navigate("movement_page")}, contentColor = Color.White, backgroundColor = MaterialTheme.colors.primary ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "fab icon")
                }
            },


            content = {

//            ) {


                            run {

                            when (transactions) {
                                is DataResult.Loading -> LoadingIndicator()
                                is DataResult.Error -> ErrorMessage((transactions as DataResult.Error).error)
                                is DataResult.Success -> ContentHome(
                                    (transactions as DataResult.Success<List<Movement>>).data,
                                    user, navController
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

) {
    LazyColumn (  modifier = Modifier.background(  color = Color(0xFFA1E2C8))){
        item {
            if (profile is DataResult.Success) {
                Text(text = " ${profile.data.name}!")
            }
            Balance(navController= NavController(LocalContext.current))
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
                           .background(Color.Transparent)
                           .padding(10.dp)
                           .clip(CircleShape)
                           .border(5.dp, shape = RoundedCornerShape(5.dp), color = Color.White)
//                           .clickable { navController.navigate("detail_page")}


                   )
                       Text(text = "despesa")}
                       else {
                       Image(
                           painter =  painterResource(R.drawable.monetization_on_black_24dp),
                           contentDescription = "Profile Image",
                           contentScale = ContentScale.Fit,
                           modifier = Modifier
                               .height(56.dp)
                               .clip(CircleShape)
//                               .border(1.dp, color = Color.DarkGray)
                               .background(Color.Transparent)
                               .padding(10.dp)
                               .clip(CircleShape)

                       )}

                   Text(text = "receita")                  },

                title = movement.descriptionMovement,


                subtitle = "",
//
//                movement.typeMovement ?: "",


                    value = {
                    Text(text = "R$ ${movement.valueMovement}")
                },


                onDetailNavigate = {
                    navController.navigate("detail_page"/*TODO${movement.idMovement}*/)
                }
            )

        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = NavController(LocalContext.current))
}


//value = {
//    Text(text = "+ R$ 45", color = Color.Green, fontWeight =
//    FontWeight. Bold, fontSize =  20.sp)
//}