package br.com.digitalhouse.meuboletopago.android

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.digitalhouse.meuboletopago.android.delete.DeleteScreen
import br.com.digitalhouse.meuboletopago.android.detailing.DetailingScreen
import br.com.digitalhouse.meuboletopago.android.edit.EditScreen
import br.com.digitalhouse.meuboletopago.android.home.HomeScreen
import br.com.digitalhouse.meuboletopago.android.login.LoginScreen
import br.com.digitalhouse.meuboletopago.android.movement.MovementScreen
import br.com.digitalhouse.meuboletopago.android.password.PasswordScreen
import br.com.digitalhouse.meuboletopago.android.signup.SignupScreen

@Composable
fun Navigator(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login", builder = {
        composable("login", content = { LoginScreen(navController = navController) })
        composable("signup", content = { SignupScreen(navController = navController) })
        composable("password", content = { PasswordScreen(navController = navController) })
        composable("home", content = { HomeScreen(navController = navController)})
        composable("detailing", content = { DetailingScreen(navController = navController) })
        composable("movement", content = { MovementScreen(navController = navController) })
        composable("delete", content = { DeleteScreen(navController = navController) })
        composable("edit", content = { EditScreen(navController = navController) })
    })
}