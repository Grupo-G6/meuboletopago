package br.com.digitalhouse.meuboletopago.android.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme

private val buttonSize = 260.dp /*TODO: criar padrão para o botão*/

/*
@Composable
fun DeletePage(/*TODO: navController: NavController, ctx: Context*/){
    var dialogShow = remember { mutableStateOf(false) }
    MyApplicationTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column {
                TopAppBar(
                    title = {
                        Text(
                            textAlign = TextAlign.Center,
                            text = "Excluir",
                            fontSize = 18.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { /*navController.popBackStack() */}) {
                            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
                        }
                    })
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.padding(20.dp))
                    Column(horizontalAlignment = Alignment.CenterHorizontally){
                        Column(
                            modifier = Modifier.padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            OutlinedButton(
                                onClick = { /*Toast.makeText(ctx, "Solicitação Confirmada", Toast.LENGTH_SHORT).show()
                                navController.navigate("home_page")
                                Toast.makeText(ctx, "Registro Excluído", Toast.LENGTH_SHORT).show()*//*TODO: verificar o uso dos toasts*/
                                },
                                modifier = Modifier.width(buttonSize),/*TODO: criar padrão para o botão*/
                                border = BorderStroke(
                                    width = 2.dp,
                                    color = MaterialTheme.colors.primary /*TODO: usar cor do tema*/
                                )
                            ) {
                                Icon(imageVector = Icons.Default.Delete, contentDescription = "") /*TODO: adicionar descrições nos ícones*/
                                Text(text = "Excluir esse registro")
                            }
                            Spacer(modifier = Modifier.padding(5.dp))
                            OutlinedButton(
                                onClick = { /*Toast.makeText(ctx, "Solicitação Confirmada", Toast.LENGTH_SHORT).show()
                                navController.navigate("home_page")
                                Toast.makeText(ctx, "Registro Excluído", Toast.LENGTH_SHORT).show()*//*TODO: verificar o uso dos toasts*/
                                },
                                modifier = Modifier.width(buttonSize),/*TODO: criar padrão para o botão*/
                                border = BorderStroke(
                                    width = 2.dp,
                                    color = MaterialTheme.colors.primary /*TODO: usar cor do tema*/
                                )
                            ) {
                                Icon(imageVector = Icons.Default.Delete, contentDescription = "") /*TODO: adicionar descrições nos ícones*/
                                Text(text = "Excluir todos registros")
                            }
                        }


                    }
                }
            }
        }
    }
}
 */

@Preview()
@Composable
fun DeletePage_Preview(){
    DeletePage()
}


@Composable
fun DeletePage() {
    var dialogShow = remember { mutableStateOf(false) }
    MyApplicationTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            textAlign = TextAlign.Center,
                            text = "Excluir",
                            fontSize = 18.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
                        }
                    }
                )
            },
            content = {
                Column(
                    modifier = Modifier.padding(it)
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Spacer(modifier = Modifier.padding(20.dp))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        Column(
                            modifier = Modifier.padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            OutlinedButton(
                                onClick = {/*
                                Toast.makeText(ctx, "Solicitação Confirmada", Toast.LENGTH_SHORT).show()
                                navController.navigate("home_page")
                                Toast.makeText(ctx, "Registro Excluído", Toast.LENGTH_SHORT).show()
                                */
                                },
                                modifier = Modifier.width(buttonSize),
                                border = BorderStroke(
                                    width = 2.dp,
                                    color = MaterialTheme.colors.primary
                                )
                            ){
                                Icon(imageVector = Icons.Default.Delete, contentDescription = "")
                                Text(text = "Excluir esse registro")
                            }
                        }

                        Spacer(modifier = Modifier.padding(5.dp))

                        OutlinedButton(
                            onClick = {/*
                            Toast.makeText(ctx, "Solicitação Confirmada", Toast.LENGTH_SHORT).show()
                            navController.navigate("home_page")
                            Toast.makeText(ctx, "Registro Excluído", Toast.LENGTH_SHORT).show()
                            */
                            },
                            modifier = Modifier.width(buttonSize),
                            border = BorderStroke(
                                width = 2.dp,
                                color = MaterialTheme.colors.primary
                            )
                        ){
                            Icon(imageVector = Icons.Default.Delete, contentDescription = "")
                            Text(text = "Excluir todos registros")
                        }

                    }

                }
            }
        )
    }
}
