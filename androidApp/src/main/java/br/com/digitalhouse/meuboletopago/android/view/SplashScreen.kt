package com.learnandroid.meuboletopago

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.android.R
import kotlinx.coroutines.delay

/*VER QUAL SPLASHSCREEN ESTÁ SENDO APLICADO E EXCLUIR O OUTRO*/
@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    val subject = remember { true }
    MyApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            LaunchedEffect(subject) {
                scale.animateTo(
                    targetValue = 0.7f,
                    animationSpec = tween(
                        durationMillis = 400,
                        easing = {
                            OvershootInterpolator(4f).getInterpolation(it)
                        })
                )
                delay(1500L)
//                navController.navigate("login")
            }
            Image(
                painter = painterResource(R.drawable.meu_boleto_pago_vector),
                contentDescription = ""
            )
        }
    }
}



