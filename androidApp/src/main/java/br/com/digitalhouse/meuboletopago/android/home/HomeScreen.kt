import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.android.components.CenterTopBar
import br.com.digitalhouse.meuboletopago.android.home.HomeViewModel
import br.com.digitalhouse.meuboletopago.model.Transaction
import br.com.digitalhouse.meuboletopago.util.DataResult

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController){
    val viewModel = viewModel<HomeViewModel>()
    val transactions by viewModel.transactions.collectAsState()

    MyApplicationTheme {
        Scaffold(
            topBar = {
                CenterTopBar(
                    title = "Controle de Despesas",
                    navController = navController

                ) },
            bottomBar = { Box(){
                Column(modifier = Modifier
                    .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.End
                ) {
                    Text( textAlign = TextAlign.End, text = "Receitas: R$0.00", fontSize = 14.sp, color = Color.White,
                        modifier = Modifier.padding(8.dp,0.dp))
                    Text( textAlign = TextAlign.End, text = "Despesas: R$0.00", fontSize = 14.sp, color = Color.White,
                        modifier = Modifier.padding(8.dp,0.dp))
                    Text( textAlign = TextAlign.End, text = "Saldo: R$0.00", fontSize = 16.sp, color = Color.White,
                        fontWeight = FontWeight.Bold,modifier = Modifier.padding(8.dp,0.dp))
                }
//                IconButton(onClick = {/*TODO: navController.navigate("hint_page") */}) {
//                    Icon(imageVector = Icons.Filled.Info, contentDescription = "Informações", tint = Color.White)
//                }
            } }
        ) {  _ ->

            when (transactions) {
                is DataResult.Loading -> LoadingIndicator()
                is DataResult.Error -> ErrorMessage((transactions as DataResult.Error).error)
                is DataResult.Success -> ContentHome(transactions as DataResult.Success<List<Transaction>>)
                else -> Unit
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
        Text(text = "Oooops! Algo deu errado ${error.message}")
    }
}

@Composable
fun LoadingIndicator(){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ContentHome(resultado: DataResult.Success<List<Transaction>>) {
    val transactions = resultado.data

    LazyColumn {
        item {
            println("transactions: $transactions")
        }
//        items(transactions.size) {
//            ListItemComponent(
//                image = painterResource(id = R.drawable.ic_exclamacao),
//                title = transactions[it].descriptionMovement,
//                subtitle = transactions[it].typeMovement,
//                value = {
//                    Text(text = "R$ ${transactions[it].valueMovement}.")
//                }
//            )
//        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = NavController(LocalContext.current))
}