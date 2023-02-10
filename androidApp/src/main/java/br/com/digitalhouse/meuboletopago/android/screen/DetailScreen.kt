package br.com.digitalhouse.meuboletopago.android.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme

@Composable
fun Detalhe() {
    var state by remember { mutableStateOf(true) }
    MyApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column(modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                TopAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    title = {
                        Text(text = "Detalhes")
                    },
                    navigationIcon = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
                        }
                    },
//            backgroundColor = Color.Blue,
                    contentColor = Color.White,
                    elevation = 8.dp
                )

                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        shape = RoundedCornerShape(16.dp),
                        backgroundColor = Color(0xFF364B9B)
                    ){
                        Column(modifier = Modifier.fillMaxWidth(),
                            verticalArrangement = Arrangement.Center) {
                            Text(
                                text = "Academia",
                                fontSize = 20.sp,
                                modifier = Modifier.padding(16.dp),
                                color = Color.White,
                                textAlign = TextAlign.Center
                            )
                            Column(modifier = Modifier.fillMaxWidth()) {
                                Text(
                                    text = "Vencimento: 03/02/2013",
                                    modifier = Modifier.padding(16.dp),
                                    color = Color.White
                                )
                                Text(
                                    text = "Valor: R$110,00",
                                    modifier = Modifier.padding(16.dp),
                                    color = Color.White
                                )
                            }
                        }
                    }
                }


                Row(
                    Modifier.selectableGroup(),
                    verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = state,
                        onClick = { state = true },
                        modifier = Modifier.semantics { contentDescription = "Localized Description" },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color(0xFF7BC59D),
                            unselectedColor = Color.LightGray
                        )

                    )
                    Text(text = "Pago")
                    RadioButton(
                        selected = !state,
                        onClick = { state = false },
                        modifier = Modifier.semantics { contentDescription = "Localized Description" },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color(0xFF7BC59D),
                            unselectedColor = Color.LightGray
                        )
                    )
                    Text(text = "Não pago",
                        textAlign = TextAlign.Center)
                }
                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {
                    Button(modifier = Modifier.padding(16.dp),
                        onClick = {/*TODO*/},
                        colors = ButtonDefaults.buttonColors(Color(0xFF7BC59D))){
                        Text(text = "Editar",
                            color = Color.White)
                    }
                    Button(modifier = Modifier.padding(16.dp),
                        onClick = {/*TODO*/},
                        colors = ButtonDefaults.buttonColors(Color(0xFF7BC59D))){
                        Text(text = "Excluir",
                            color = Color.White)
                    }
                }

            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    Detalhe()
}