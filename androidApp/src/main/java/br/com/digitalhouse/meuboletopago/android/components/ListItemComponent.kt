package br.com.digitalhouse.meuboletopago.android.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun ListItemComponent(
    image: Painter,
    title: String,
    subtitle: String,
    value: @Composable () -> Unit = {},
    status: @Composable () -> Unit = {},
    onDetailNavigate: () -> Unit = {}
) {
    Card (
        modifier = Modifier.padding(bottom = 0.5.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .clickable { onDetailNavigate.invoke() }
        ) {
            image
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text(text = title, fontWeight = FontWeight.Bold, fontSize = 17.sp)
                Text(text = subtitle, fontSize = 13.sp, color = Color.Gray)
            }
            Spacer(modifier = Modifier.weight(1f))
            value()
        }
    }
}

//@Preview
//@Composable
//fun ListItemComponent_Preview() {
//    val painter = rememberAsyncImagePainter(model =
//    ImageRequest.Builder(LocalContext.current)
//        .data("https://media.licdn.com/dms/image/C4E03AQGzYGYIlmUzbg/profile-displayphoto-shrink_800_800/0/1640531489913?e=2147483647&v=beta&t=qmWLp-OvACiTmOfMIYk-T3bCq1R-KQkB7jXM9UsGvfI")
//        .size(50)
//        .placeholder(android.R.drawable.ic_delete)
//        .build()
//    )
//
//    ListItemComponent(
//        image = {
//            Image(
//                painter = painter,
//                contentDescription = "Profile Image",
//                contentScale = ContentScale.Fit,
//                modifier = Modifier
//                    .height(56.dp)
//                    .width(56.dp)
//                    .clip(CircleShape)
//                    .background(Color(0x1CFD3C72))
//                    .padding(10.dp)
//                    .clip(CircleShape)
//            )
//        },
//        title = "Dribble Inc",
//        subtitle = "Crédito",
//        value = {
//            Text(text = "+ R$ 45", color = Color.Green, fontWeight = FontWeight.Bold, fontSize = 20.sp)
//        }
//    )
//}