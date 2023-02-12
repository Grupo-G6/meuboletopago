package br.com.digitalhouse.meuboletopago.android.home

import android.R
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.android.component.CenterTopBar
import br.com.digitalhouse.meuboletopago.android.component.DetailCard
import br.com.digitalhouse.meuboletopago.model.Mock
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController)  {
    val spacer: Dp = 16.dp
    MyApplicationTheme() {
        Scaffold (
            topBar = { CenterTopBar(title = "Controle de Despesas", navController = navController)}
        ) {
            LazyColumn{
                val transactions = Mock.transacoes
                item{
                    Button(
                        onClick = { navController.navigate("detailing") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(spacer),) {
                        Text(text = "Detalhamento", color = Color.White)
                    }
                }
                items(transactions.size) {
                    val painter = rememberAsyncImagePainter(model =
                    ImageRequest.Builder(LocalContext.current)
                        .data(transactions[it].logo)
                        .size(50)
                        .placeholder(R.drawable.ic_delete)
                        .build()
                    )
                    DetailCard(
                        description = transactions[it].title,
                        dueDate = transactions[it].date,
                        valueMovement = transactions[it].value,
                    )
                }


//                    ListItemComponent(
//
//                        image = {
//                            Image(
//                                painter = painter,
//                                contentDescription = "Profile Image",
//                                contentScale = ContentScale.Fit,
//                                modifier = Modifier
//                                    .height(56.dp)
//                                    .width(56.dp)
//                                    .clip(CircleShape)
//                                    .background(Color(0x1CFD3C72))
//                                    .padding(10.dp)
//                                    .clip(CircleShape)
//                            )
//                        },
//                        title = transactions[it].title,
//                        subtitle = transactions[it].transactionType.description,
//                        value = {
//                            if (transactions[it].status)
//                                Text(
//                                    text = "+ R$${transactions[it].value}",
//                                    color = Color.Green,
//                                    fontWeight = FontWeight.Bold,
//                                    fontSize = 20.sp
//                                )
//                            else
//                                Text(
//                                    text = "- R$${transactions[it].value}",
//                                    color = Color.Red,
//                                    fontWeight = FontWeight.Bold,
//                                    fontSize = 20.sp
//                                )
//                        }
//                    )
//                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreen_Preview() {
    HomeScreen(navController = NavController(LocalContext.current))
}