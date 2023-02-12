package br.com.digitalhouse.meuboletopago.android.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class StateType(){
    PENDENTE,
    PAGO
}

@Composable
fun DetailCard(
    description: String,
    dueDate: String,
    valueMovement: Double
) {
    val checkedState = remember { mutableStateOf(false) }
    val textState = remember { mutableStateOf(StateType.PENDENTE.name) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, color = Color.LightGray),
        backgroundColor = MaterialTheme.colors.primaryVariant,
        elevation = 30.dp
    ){
        Column(modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center) {
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = description,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(16.dp),
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
                Column(verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(text = textState.value)
                    Spacer(modifier = Modifier.width(300.dp))
                    Switch(
                        checked = checkedState.value,
                        onCheckedChange = { checkedState.value = it
                            textState.value = if (it) StateType.PAGO.name else StateType.PENDENTE.name},
                    )
                }
            }

            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Vencimento: $dueDate",
                    modifier = Modifier.padding(16.dp),
                    color = Color.White
                )
                Text(
                    text = "Valor: R$$valueMovement",
                    modifier = Modifier.padding(16.dp),
                    color = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun DetailCard_Preview(){
    DetailCard(description = "teste", dueDate = "teste", valueMovement = 4.0)
}
