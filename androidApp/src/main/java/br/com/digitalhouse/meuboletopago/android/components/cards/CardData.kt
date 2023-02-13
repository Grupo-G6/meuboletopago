package com.learnandroid.meuboletopago.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.learnandroid.meuboletopago.ui.theme.teal200

@Composable
fun CardData(): Unit{

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
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

                    .background(color = teal200),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally

            ){
                Text(text = "Icone", fontSize = 14.sp, color = Color.Black, fontWeight = FontWeight.Bold )
            }

                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(125.dp)
                        .background(color = teal200),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ){
                    Text(text = "Descrição", fontSize = 14.sp, color = Color.Black, fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(8.dp,0.dp))
                    Spacer(modifier = Modifier.size(30.dp))
                    Text(text = "Tipo", fontSize = 14.sp, color = Color.Black, fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(8.dp,0.dp))
                }

                   Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(125.dp)
                            .background(color = teal200),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.End
                    ){
                        Text(text = "R$0,00", fontSize = 14.sp, color = Color.Black, fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(8.dp,0.dp) )
                        Spacer(modifier = Modifier.size(30.dp))
                        Text(text = "dd/mm/aa", fontSize = 14.sp, color = Color.Black, fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(8.dp,0.dp) )
                    }




                }
            }

        }
    }

}

@Preview
@Composable
fun DataCardPreview(){
    CardData()
}