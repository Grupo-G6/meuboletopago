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

import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.android.components.DetailCard

@Composable
fun Detalhe() {
    MyApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
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
                    contentColor = Color.White,
                    elevation = 8.dp
                )

                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {
                    DetailCard(description = "Academia",
                        dueDate = "03/02/2023",
                        valueMovement = "110,00")
                }

                Row(horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically) {
                    Button(modifier = Modifier.padding(16.dp),
                        onClick = {/*TODO*/},
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colors.primary)){
                        Text(text = "Editar",
                            color = Color.White)
                    }
                    Button(modifier = Modifier.padding(16.dp),
                        onClick = {/*TODO*/},
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colors.primary)){
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