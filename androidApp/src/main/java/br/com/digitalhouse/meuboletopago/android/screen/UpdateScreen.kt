package br.com.digitalhouse.meuboletopago.android.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme

@Composable
fun UpdateScreen(/*TODO:navController: NavController*/) {

    var selectedOption = remember { mutableStateOf("") }
//    val context = AmbientContext.current
    val description = remember { mutableStateOf("") }
    val value = remember { mutableStateOf("") }
    val date = remember { mutableStateOf("") }
    val scaffoldState = rememberScaffoldState(
        rememberDrawerState(initialValue = DrawerValue.Closed)
    )
    MyApplicationTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            textAlign = TextAlign.Center,
                            text = "Editar",
                            fontSize = 18.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {/*TODO: navController.popBackStack()*/ }) {
                            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
                        }
                    }
                )
            },
            content = {


                Column(
                    modifier = Modifier
                        .padding(it)
                        .background(Color.White)
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally,
                )


                {
                    Spacer(modifier = Modifier.padding(20.dp))
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        Column(
                            modifier = Modifier.padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            OutlinedTextField(
                                value = description.value,
                                onValueChange = { description.value = it },
                                label = { Text(text = "Descrição") },
                                placeholder = { Text(text = "Descrição") },
                                singleLine = true,
                                modifier = Modifier.fillMaxWidth(0.8f)
                            )

                            OutlinedTextField(
                                value = value.value,
                                onValueChange = { value.value = it },
                                label = { Text(text = "Valor") },
                                placeholder = { Text(text = "Valor") },
                                singleLine = true,
                                modifier = Modifier.fillMaxWidth(0.8f),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                            )

                            OutlinedTextField(
                                value = date.value,
                                onValueChange = { date.value = it },
                                label = { Text(text = "Data") },
                                placeholder = { Text(text = "dd/mm/aa") },
                                singleLine = true,
                                modifier = Modifier.fillMaxWidth(0.8f),
                                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                            )


                            Spacer(modifier = Modifier.padding(10.dp))
                            Button(
                                onClick = {/*TODO:
                                navController.navigate("home_page")
                                Toast.makeText(context, "Registro Salvo", Toast.LENGTH_SHORT).show()*/
                                },
                                modifier = Modifier
                                    .fillMaxWidth(0.8f)
                                    .height(50.dp)
                            ) {
                                Text(text = "Salvar", fontSize = 20.sp)

                            }

                            Spacer(modifier = Modifier.padding(20.dp))

                        }

                    }
                }
            }
        )
    }
}

@Preview
@Composable
fun UpdateScreen_Preview(){
    UpdateScreen()
}