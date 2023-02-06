package com.learnandroid.meuboletopago.composables


import android.widget.Toast
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
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.learnandroid.meuboletopago.Object.MovementType
import com.learnandroid.meuboletopago.ui.theme.primaryColor


@Composable
fun MovementPage(navController: NavController ) {

    var selectedOption = remember { mutableStateOf("") }
    val context = AmbientContext.current
    val description = remember { mutableStateOf("") }
    val value = remember { mutableStateOf("") }
    val date = remember { mutableStateOf("") }
    val scaffoldState = rememberScaffoldState(
        rememberDrawerState(initialValue = DrawerValue.Closed)
    )

    Scaffold(

                topBar = {
                    primaryColor
            TopAppBar(
                backgroundColor = Color(0xFF7048B6),
                title = {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Movimentação",
                        fontSize = 18.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack)

                    }
                }
            )
        },
        bodyContent = {


            Column(
                modifier = Modifier
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

                        Row {
                            RadioButton(
                                selected = selectedOption.value == MovementType.expense,
                                onClick = { selectedOption.value = MovementType.expense },
                                colors = RadioButtonDefaults.colors(Color.Red)
                            )
                            Spacer(modifier = Modifier.size(2.dp))
                            Text(MovementType.expense)
                            Spacer(modifier = Modifier.size(16.dp))


                            RadioButton(
                                selected = selectedOption.value == MovementType.revenue,
                                onClick = { selectedOption.value = MovementType.revenue },
                                colors = RadioButtonDefaults.colors(Color.Green)
                            )
                            Spacer(modifier = Modifier.size(2.dp))
                            Text(MovementType.revenue)
                            Spacer(modifier = Modifier.size(16.dp))
                        }

                        Spacer(modifier = Modifier.size(10.dp))


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
                            placeholder = { Text(text = "Data") },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(0.8f),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )


                        Spacer(modifier = Modifier.padding(10.dp))
                        Button(
                            onClick = {
                                navController.navigate("update_page")
                                Toast.makeText(context, "Registro Salvo", Toast.LENGTH_SHORT).show()
                            },
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(50.dp)
                        ) {
                            Text(text = "Salvar", fontSize = TextUnit.Sp(20))

                        }

                        Spacer(modifier = Modifier.padding(20.dp))

                    }

                }
            }
        }
    )
}


/*@Preview
@Composable
fun PrimeiraTelaPreview() {
    PrimeiraTela(navController = NavController())
}*/