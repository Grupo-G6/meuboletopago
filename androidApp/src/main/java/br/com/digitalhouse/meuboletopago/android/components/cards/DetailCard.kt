package br.com.digitalhouse.meuboletopago.android.components.cards


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.digitalhouse.meuboletopago.android.R

enum class StateType(){
    PENDENTE,
    PAGO
}
enum class TypeMovement(){
    Receita,
    Despesa
}

@Composable
fun DetailCard(description: String,
               dueDate: String,
               valueMovement: String,
               wasPaid: Boolean,
               typeMovement: String
) {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    textState.value = if (wasPaid){
        TextFieldValue(StateType.PAGO.name)
    } else {
        TextFieldValue(StateType.PENDENTE.name)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, color = Color.LightGray),
        backgroundColor = MaterialTheme.colors.primaryVariant,
        elevation = 30.dp
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = description,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Normal,
                    fontSize = 24.sp,
//                    fontSize = 20.sp,
                    modifier = Modifier.padding(16.dp),
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier.padding(16.dp).fillMaxWidth()
                ) {
//                    if (!wasPaid) {
//                        Details(state = textState.value.text, img = R.drawable.barcode_fill0_wght400_grad0_opsz48)
//                    } else  {
//                        Details(state = textState.value.text, img = R.drawable.payments_fill0_wght400_grad0_opsz48)
//                    }
                }
            }
                Row {
                    Column(modifier = Modifier.fillMaxWidth()) {

                        Text(
                            text = "Vencimento: $dueDate",
                            modifier = Modifier.padding(16.dp),
                            color = Color.White
                        )
                        Text(
                            text = "Valor: R$ $valueMovement",
                            modifier = Modifier.padding(16.dp),
                            color = Color.White
                        )
                        Text(
                            text = if (typeMovement == "2"){
                                                           TypeMovement.Despesa.name
                                                           } else {
                                TypeMovement.Receita.name
                                                                  },
                            modifier = Modifier.padding(16.dp),
                            color = Color.White

                        )

                    }
                }
        }
    }
}

@Composable
fun Details(state: String, img: Int){
    Column(modifier= Modifier.width(90.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = state)
        Spacer(modifier = Modifier.width(300.dp))
        Image(
            painter = painterResource(id = img),
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
        )
    }
}

@Preview
@Composable
fun DetailCard_Preview(){
    DetailCard(
        description = "teste",
        dueDate = "teste",
        valueMovement = "teste",
        typeMovement = "1",
        wasPaid = true
    )
}


