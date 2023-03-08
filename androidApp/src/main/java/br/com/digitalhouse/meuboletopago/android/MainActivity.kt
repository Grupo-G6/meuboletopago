package br.com.digitalhouse.meuboletopago.android


import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen


class MainActivity : ComponentActivity() {
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color =  MaterialTheme.colors.primaryVariant
                ) {
                    Navigator(ctx = this@MainActivity)
                   sharedPreferences = getSharedPreferences("boletopago", MODE_PRIVATE)
                }
            }
        }
    }
    fun getPreferences(): SharedPreferences =  sharedPreferences


}



