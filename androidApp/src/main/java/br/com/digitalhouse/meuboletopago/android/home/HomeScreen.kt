import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.android.R
import br.com.digitalhouse.meuboletopago.android.components.CenterTopBar
import br.com.digitalhouse.meuboletopago.android.components.ListItemComponent
import br.com.digitalhouse.meuboletopago.android.components.LoadingIndicator
import br.com.digitalhouse.meuboletopago.android.components.TopBar
import br.com.digitalhouse.meuboletopago.android.components.cards.MovementCard
import br.com.digitalhouse.meuboletopago.android.home.HomeViewModel
import br.com.digitalhouse.meuboletopago.model.Transaction
//import br.com.digitalhouse.meuboletopago.model.Mock
import br.com.digitalhouse.meuboletopago.util.DataResult
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController, /*onItemDetail:(Long)-> Unit */) {
    val viewModel = viewModel<HomeViewModel>()
    val trans by viewModel.homeState.collectAsState()
    val isLogged = remember { mutableStateOf(false) }
//    val profile by viewModel.transactions.collectAsState()
    val showDialog = remember { mutableStateOf(true) }
    val listTransactions = remember{ mutableStateOf(emptyList<Transaction>()) }

    MyApplicationTheme {
        Scaffold(
            topBar = {
                CenterTopBar(
                    title = "Controle de Despesas",
                    navController = navController

                )
            }
        )
        { _ ->
            when (trans) {
                is DataResult.Loading -> LoadingIndicator()
                is DataResult.Error -> ErrorMessage((trans as DataResult.Error).error)
                is DataResult.Success -> ContentHome(trans as DataResult.Success<List<Transaction>> /*onItemDetail*/)
                is DataResult.Empty ->  /*trans as DataResult.Empty*/
                viewModel.defaultState()


            }
            }
        }
    }




@Composable
fun ErrorMessage(error: Throwable) {
       Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "Oooop! deu erro ${error.message}")
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
fun ContentHome(resultado: DataResult.Success<List<Transaction>> /*onItemDetail:(Long)-> Unit*/  ) {
    val transactions = resultado.data

//        val isLoading = remember{ mutableStateOf(false) }

//        when (state) {
//            is DataResult.Loading ->{isLoading.value = state.isLoading}
//            is DataResult.Error -> ErrorMessage(state.error)
//            is DataResult.Success -> {
//                listTransactions.value = state.data
//            }
//            else -> Unit
//        }
//    val transactions = listTransactions.value
    LazyColumn {

            item {
                LoadingIndicator()
            }
        items(transactions.size){

            Text(text = "${transactions[it].idMovement}")
        }
            item {
               MovementCard()
            }

//            item {
//                Button(onClick = {
//
//                    })
//
//
//
//            }



            items(transactions.size) {
                val painter = rememberAsyncImagePainter(
                    model =
                    ImageRequest.Builder(LocalContext.current)
                        .data(transactions[it] )
                        .size(50)
                        .placeholder(R.drawable.ic_exclamacao)
                        .build(),
                )

                ListItemComponent(
                    image = {
                        Image(
                            painter = painter,
                            contentDescription = "Profile Image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .height(56.dp)
                                .width(56.dp)
                                .clip(CircleShape)
                                .background(Color.Red.copy(alpha = 0.11f))
                                .padding(10.dp)
                                .clip(CircleShape),
                        )
                    },
                    title = transactions[it].descriptionMovement.toString(),
                    subtitle = transactions[it].typeMovement.toString(),

                    value = {
                        Text(text = "R$ ${transactions[it]}")
                    },
                )
            }
        }
    }


    @Preview
    @Composable
    fun HomeScreen_Preview() {
        HomeScreen(navController = NavController(LocalContext.current) /*onItemDetail = {}*/)
    }
