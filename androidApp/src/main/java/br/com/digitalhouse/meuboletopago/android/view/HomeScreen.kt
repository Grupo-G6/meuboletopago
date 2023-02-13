import android.content.Context
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.android.R
import com.learnandroid.meuboletopago.component.CardInfo

val cardInfo = listOf<CardInfo>(
    CardInfo("Receita", R.drawable.icone_ticado,"Descrição", 0.00, "dd/mm/aa"),
    CardInfo("Despesa", R.drawable.icone_exclamcao,"Descrição", 0.00, "dd/mm/aa"),
    CardInfo("Receita", R.drawable.icone_ticado,"Descrição", 0.00, "dd/mm/aa"),
    CardInfo("Despesa", R.drawable.icone_exclamcao,"Descrição", 0.00, "dd/mm/aa"),
    CardInfo("Receita", R.drawable.icone_ticado,"Descrição", 0.00, "dd/mm/aa"),
    CardInfo("Despesa", R.drawable.icone_exclamcao,"Descrição", 0.00, "dd/mm/aa"),
    CardInfo("Receita", R.drawable.icone_ticado,"Descrição", 0.00, "dd/mm/aa"),
    CardInfo("Despesa", R.drawable.icone_exclamcao,"Descrição", 0.00, "dd/mm/aa"),
    CardInfo("Receita", R.drawable.icone_ticado,"Descrição", 0.00, "dd/mm/aa"),
    CardInfo("Despesa", R.drawable.icone_exclamcao,"Descrição", 0.00, "dd/mm/aa"),
    CardInfo("Receita", R.drawable.icone_ticado,"Descrição", 0.00, "dd/mm/aa"),
    CardInfo("Despesa", R.drawable.icone_exclamcao,"Descrição", 0.00, "dd/mm/aa"),
    CardInfo("Receita", R.drawable.icone_ticado,"Descrição", 0.00, "dd/mm/aa"),
    CardInfo("Despesa", R.drawable.icone_exclamcao,"Descrição", 0.00, "dd/mm/aa"),
    CardInfo("Receita", R.drawable.icone_ticado,"Descrição", 0.00, "dd/mm/aa"),
    CardInfo("Despesa", R.drawable.icone_exclamcao,"Descrição", 0.00, "dd/mm/aa"),
)

@Composable
fun HomeScreen(navController: NavController, cardInfo: List<CardInfo>, ctx: Context){
    val scaffoldState = rememberScaffoldState(
        rememberDrawerState(initialValue = DrawerValue.Closed))

    MyApplicationTheme {
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = { TopAppBar(
                title = { Text(
                    textAlign = TextAlign.Justify,
                    text = "Controle de Despesas",
                    fontSize = 22.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,)

                })},
            floatingActionButton = { FloatingActionButton(onClick = { navController.navigate("create_movement_page")},
            ) {
                Icon(imageVector = Icons.Default.Add,
                    contentDescription = "Adicionar movimentações",
                    tint = Color.White,
                )
            }},
            floatingActionButtonPosition = FabPosition.End,

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

        ) {
            Tela(modifier = Modifier.padding(it), cardInfo, navController, ctx)
        }
    }

}
@Composable
fun Tela(modifier: Modifier, cardInfo: List<CardInfo>, navController: NavController, ctx: Context){

LazyColumn{
        itemsIndexed(cardInfo){
                index, item ->  meuCard(cardInfo[index], navController, ctx)
        }
    }

}

@Composable
fun meuCard(cardInfo: CardInfo, navController: NavController, ctx: Context){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(

            modifier = Modifier
                .clickable(onClick = {navController.navigate("detail_page")   })


                .border(
                    border = BorderStroke(2.dp, color = Color.LightGray),
                    shape = RoundedCornerShape(10.dp)
                )
                .height(100.dp)
                .width(350.dp),
            shape = RoundedCornerShape(10.dp),
            elevation = 10.dp

        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                //.background(Color.LightGray),
                //verticalArrangement = Arrangement.Center,
                //horizontalAlignment = Alignment.CenterHorizontally
            ){
                Row() {

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(100.dp)
                            .background(color = Color.Transparent),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ){
                        //Text(text = "Icone", fontSize = 14.sp, color = Color.Black, fontWeight = FontWeight.Bold )
                        Image(painter = painterResource(id = cardInfo.imagem),
                            contentDescription = "",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .height(50.dp)
                                .width(50.dp))
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(125.dp)
                            .background(color = Color.Transparent),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.Start
                    ){
                        Text(text = cardInfo.descricao, fontSize = 14.sp, color = Color.Black, fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(8.dp,0.dp))
                        Spacer(modifier = Modifier.size(30.dp))
                        Text(text = cardInfo.tipo, fontSize = 14.sp, color = Color.Black, fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(8.dp,0.dp))
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(125.dp)
                            .background(color = Color.Transparent),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.End
                    ){
                        Text(text = "R$"+cardInfo.valor.toString()+"0", fontSize = 14.sp, color = Color.Black, fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(8.dp,0.dp) )
                        Spacer(modifier = Modifier.size(30.dp))
                        Text(text = cardInfo.data, fontSize = 14.sp, color = Color.Black, fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(8.dp,0.dp) )
                    }




                }
            }

        }
    }

    Spacer(modifier = Modifier.padding(8.dp))
}
