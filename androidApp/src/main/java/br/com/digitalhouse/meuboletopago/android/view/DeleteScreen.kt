package br.com.digitalhouse.meuboletopago.android.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
//import kotlinx.coroutines.flow.internal.NoOpContinuation.context
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context


//class DeleteScreen : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MyApplicationTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    Delete()
//                }
//            }
//        }
//    }
//}
@Composable
fun Delete(navController: NavController) {

    var state by remember { mutableStateOf(true) }
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            modifier = Modifier.fillMaxWidth(),
            title = {
                Text(text = "Excluir registro")
            },
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
                }
            },
            backgroundColor = Color.Blue,
            contentColor = Color.White,
            elevation = 8.dp
        )

        Spacer(modifier = Modifier.padding(20.dp))
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                OutlinedButton(
                    onClick = {
//                                Toast.makeText(context, "Solicitação Confirmada", Toast.LENGTH_SHORT).show()
//                                navController.navigate("login_page")
//                                Toast.makeText(context, "Registro Excluído", Toast.LENGTH_SHORT).show()
                    },
//                    border = BorderStroke(
//                        width = 2.dp,
//                        color = Color.Green
//                    )
                ) {
//                    Icon(
//                        Icons.Default.Delete,
//                    )
                    Text(text = "Excluir esse registro")
                }
            }

            Spacer(modifier = Modifier.padding(5.dp))

//              {      OutlinedButton(
////                        onClick = {
////                            Toast.makeText(context, "Solicitação Confirmada", Toast.LENGTH_SHORT).show()
////                            navController.navigate("login_page")
////                            Toast.makeText(context, "Registro Excluído", Toast.LENGTH_SHORT).show()
////                        },
////                        border = BorderStroke(
////                            width = 2.dp,
////                            color = primaryColor
////                        )
////                    )
//            border = BorderStroke(
//                        width = 2.dp,
//                        color = Color.Green
//                    )
            OutlinedButton(
                onClick = {
//                                Toast.makeText(context, "Solicitação Confirmada", Toast.LENGTH_SHORT).show()
                     navController.navigate("home")
//                                Toast.makeText(context, "Registro Excluído", Toast.LENGTH_SHORT).show()
                },
//                    border = BorderStroke(
//                        width = 2.dp,
//                        color = Color.Green
//                    )
            ) {
//                    Icon(
//                        Icons.Default.Delete,
//                    )
                Text(text = "Excluir todos os registros")
            }
        }
        }

    }


//@Preview
//@Composable
//fun DeletePage_Preview() {
//    MyApplicationTheme {
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colors.background
//        ) {
//            Delete()
//        }
//    }
//}


