package br.com.digitalhouse.meuboletopago.android.routes

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.digitalhouse.meuboletopago.android.screen.LoginScreen
import br.com.digitalhouse.meuboletopago.android.screen.SignupScreen
import br.com.digitalhouse.meuboletopago.android.screen.SplashScreen


@Composable
fun Application(ctx : Context) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash_screen") {
        composable("login_page") { LoginScreen(/*...*/) }
        composable("signup_page") { SignupScreen(/*...*/) }
        /*...*/
    }
//    val navController = rememberNavController() {
//
//        NavHost(navController = navController, startDestination = "splash_screen", builder = {
//            composable("login_page", content = { LoginScreen(navController = navController) })
//            composable("register_page", content = { SignupScreen(navController = navController) })
//
//            composable("splash_screen", content = { SplashScreen(navController = navController) })
//
//        })
//    }
}

