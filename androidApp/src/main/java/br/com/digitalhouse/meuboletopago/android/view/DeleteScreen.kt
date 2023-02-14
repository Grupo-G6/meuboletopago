package br.com.digitalhouse.meuboletopago.android.view


import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.android.components.cards.ButtonSmall

private val buttonSize = 260.dp


@Composable
fun DeleteScreen(navController: NavController) {
    var dialogShow = remember { mutableStateOf(false) }
    val ctx = LocalContext.current
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
                        IconButton(onClick = {  navController.navigate("home") }) {
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

                            ButtonSmall(
                                "Registro excluído com sucesso!",
                                navController,
                                "home",
                                "Excluir registro"
                            )
                            Spacer(modifier = Modifier.padding(5.dp))

                            ButtonSmall(
                                "Registros excluídos com sucesso!",
                                navController,
                                "home",
                                "Excluir TODOS os registro"
                            )
///*TODO: ALTERAR TEXTOS PARA CONSTAR UMA CONFIRMAÇÃO ANTES DA EXCLUSÃO DE TODOS OS REGISTROS*/
                        }

                    }
                }
            })
    }
}