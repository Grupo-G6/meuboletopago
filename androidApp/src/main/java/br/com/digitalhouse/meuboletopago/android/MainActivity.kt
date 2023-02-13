package br.com.digitalhouse.meuboletopago.android

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.learnandroid.meuboletopago.ui.theme.LoginApplicationTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Navigator(ctx = this@MainActivity)
                }
            }
        }

        }
    }



//@RequiresApi(Build.VERSION_CODES.O)
//@Preview
//@Composable
//fun DefaultPreview() {
//    MyApplicationTheme {
//        Navigator()
//    }
//}
//
//import android.content.Context
//import android.os.Bundle
//import android.view.WindowManager
//import androidx.appcompat.app.AppCompatActivity
//import androidx.compose.ui.platform.setContent
//import br.com.digitalhouse.meuboletopago.android.Navigator
//import com.learnandroid.meuboletopago.ui.theme.LoginApplicationTheme
//
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
//        setContent {
//            LoginApplicationTheme {
//               Navigator(ctx = this@MainActivity)
//            }
//        }
//    }
//}