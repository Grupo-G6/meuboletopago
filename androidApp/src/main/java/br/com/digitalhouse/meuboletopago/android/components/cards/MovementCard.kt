package br.com.digitalhouse.meuboletopago.android.components.cards



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.lerp
import androidx.compose.ui.unit.sp
import br.com.digitalhouse.meuboletopago.android.R

import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import kotlin.math.absoluteValue

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MovementCard() {
    HorizontalPager(
        count = 3,
        contentPadding = PaddingValues(horizontal = 20.dp),
        modifier = Modifier.height(250.dp)
    ) { page ->
        val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
        Card(
            contentColor = Color.White,
            modifier = Modifier.graphicsLayer {
                lerp(
                    start = 0.92f,
                    stop = 1f,
                    fraction = 1f - pageOffset.coerceIn(0f, 1f)
                ).also {
                    scaleY = it
                    scaleX = it
                }
            }
        ) {
            DHCardContent()
        }

    }
}

@Preview
@Composable
fun DHCardGroup_Preview() {
    MovementCard()
}

@Composable
fun DHCardContent() {
    val shadow = Shadow(Color.Black, offset = Offset(2f, 2f), blurRadius = 1f)
    Column(
        modifier = Modifier
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color(0xFF4A27F4),
                        Color(0xFF454BB2)
                    )
                )
            )
            .height(202.dp)
            .padding(30.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = "Limite", fontSize = 11.sp)
                Text(text = "R$18,24", fontSize = 24.sp)
            }
            Spacer(modifier = Modifier.weight(1f))
            Image(painter = painterResource(id = R.drawable.ic_exclamacao), contentDescription = "Visa")
        }
        Spacer(modifier = Modifier.weight(1f))
        Row {
            MutableList(3) {
                Text(text = "****", fontSize = 20.sp, style = TextStyle(shadow = shadow))
                Spacer(modifier = Modifier.weight(1f))
            }

            Text(text = "1289", fontSize = 20.sp, style = TextStyle(shadow = shadow))
        }
        Spacer(modifier = Modifier.weight(1f))
        Row {
            Column {
                Text(text = "NOME", fontSize = 11.sp)
                Text(text = "DENIS ROCHA", style = TextStyle(shadow = shadow))
            }
            Spacer(modifier = Modifier.weight(1f))
            Column {
                Text(text = "VALIDADE", fontSize = 11.sp)
                Text(text = "09/24", style = TextStyle(shadow = shadow))
            }
        }
    }
}

@Preview
@Composable
fun DHCardContent_Preview() {
    DHCardContent()
}