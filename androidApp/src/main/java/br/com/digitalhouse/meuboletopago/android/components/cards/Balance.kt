package br.com.digitalhouse.meuboletopago.android.components.cards



import ErrorMessage
import LoadingIndicator
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.model.Balance
import br.com.digitalhouse.meuboletopago.model.Movement
import br.com.digitalhouse.meuboletopago.util.DataResult


@Composable
fun Balance(navController: NavController, balance: DataResult<Balance>): Unit {
    var balanceData : Balance? = null
    MyApplicationTheme() {

        when (balance) {
            is DataResult.Loading -> LoadingIndicator()
            is DataResult.Error -> ErrorMessage((balance as DataResult.Error).error)
            is DataResult.Success -> {
                balanceData = (balance as DataResult.Success<Balance>).data}

            else -> Unit
        }


//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//            .fillMaxWidth(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
            Card(
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth(),
                elevation = 10.dp,

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(  color = Color(0xFFA1E2C8)),
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                                horizontalArrangement =   Arrangement.SpaceEvenly

                    ) {

                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(100.dp)
                                .background(  color = Color(0xFFA1E2C8)),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            androidx.compose.material.Icon(
                                imageVector = Icons.Default.ArrowUpward,
                                "arrow up",
                                modifier = Modifier
                                    .padding(10.dp)
                                    .border(1.dp, color = Color(0xFF0A502E), shape = RoundedCornerShape(20.dp))
                                    .clickable { navController.navigate("home") }, tint = Color(
                                    0xFF0A502E
                                )
                            )

                            Text(
                                text = "Receitas",

//                                modifier = Modifier
//                                    .padding(15.dp),
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.Medium,
                                fontSize = 15.sp
                            )
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(100.dp),
//                                    .background(  color = Color(0xFFA1E2C8)),
                                verticalArrangement = Arrangement.Top,
                                horizontalAlignment = Alignment.CenterHorizontally

                            ) {
                                Text(
                                    text = balanceData?.credit.toString()?:"",
                                    modifier = Modifier
                                        .paddingFromBaseline(2.dp),
                                    fontFamily = FontFamily.Default,
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 15.sp,
                                    color = Color( 0xFF0A502E)
                                )

                            }

                        }

                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(100.dp),
//                                .background(  color = Color(0xFF79C9A9)),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            Text(
                                text = "Saldo",
                                modifier = Modifier.padding(5.dp),
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.Medium,
                                fontSize = 20.sp,
                                color = Color.Black
                            )
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(100.dp),
//                                    .background(  color = Color(0xFF79C9A9)),
                                verticalArrangement = Arrangement.Top,
                                horizontalAlignment = Alignment.CenterHorizontally

                            ) {
                                Text(
                                    text =  balanceData?.balance.toString()?:"",
//                                    modifier = Modifier.padding(10.dp),
                                    fontFamily = FontFamily.Default,
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 16.sp,
                                    color = Color.Black,
                                )

                            }

                        }

                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(100.dp),
//                                .background(  color = Color(0xFF79C9A9)),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally

                        ) {
                            androidx.compose.material.Icon(
                                imageVector = Icons.Default.ArrowDownward,
                                "arrow down",
                                modifier = Modifier
                                    .padding(10.dp)
                                    .border(1.dp, color = Color(0xFFC03C33), shape = RoundedCornerShape(20.dp))
                                    .clickable { navController.navigate("home") }, tint = Color(
                                    0xFFC03C33
                                )
                            )
                            Text(
                                text = "Despesas",
//                                modifier = Modifier
//                                    .padding(15.dp),
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.Medium,
                                fontSize = 15.sp
                            )
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(100.dp),
//                                    .background(  color = Color(0xFF79C9A9)),
                                verticalArrangement = Arrangement.Top,
                                horizontalAlignment = Alignment.CenterHorizontally

                            ) {
                                Text(
                                    text =  balanceData?.debt.toString()?:"",
//                                    modifier = Modifier
//                                        .paddingfromBaseline(2.dp),
                                    fontFamily = FontFamily.Default,
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 15.sp,
                                    color = Color(0xFFC03C33)
//                                            primary = Color(0xFF48A27E),
                                )


                            }

                        }


                    }
                }

            }
        }
    }

//}

//@Preview
//@Composable
//fun DataCardPreview(){
//    Balance(navController= NavController(LocalContext.current), saldo= "saldo", receita = "receita", despesa = "despesa" )
//}