package br.com.digitalhouse.meuboletopago.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import br.com.digitalhouse.meuboletopago.android.screen.ForgotPassword
import br.com.digitalhouse.meuboletopago.android.screen.HomeScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ForgotPassword()
        }
    }
}


//
//@Preview
//@Composable
//fun DefaultPreview() {
//    MyApplicationTheme {
//        GreetingView("Hello, Android!")
//    }
//}
