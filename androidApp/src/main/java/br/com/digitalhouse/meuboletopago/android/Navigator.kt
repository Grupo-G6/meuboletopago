package br.com.digitalhouse.meuboletopago.android

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.digitalhouse.meuboletopago.android.edit.EditScreen

import br.com.digitalhouse.meuboletopago.android.home.HomeScreen
import br.com.digitalhouse.meuboletopago.android.login.LoginScreen
import br.com.digitalhouse.meuboletopago.android.movement.MovementScreen
import br.com.digitalhouse.meuboletopago.android.screen.RecoverPassword
import br.com.digitalhouse.meuboletopago.android.view.SignupScreen
import com.learnandroid.meuboletopago.SplashScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigator(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login", builder = {
        composable("login", content = { LoginScreen(navController = navController) })
        composable("home", content = { HomeScreen(navController = navController)})
        composable("movement", content = { MovementScreen(navController = navController) })
        composable("edit_page", content = { EditScreen(navController = navController) })
//        composable("signup_page", content = { SignupScreen (navController = navController) })
        composable("recover_page", content = { RecoverPassword() })
//        composable("delete_page", content = { DeletePage(navController = navController) })
        composable("splash_screen", content = { SplashScreen(navController = navController) })
//        composable("detail_page", content = { DetailingScreen (navController = navController) })


    })
}