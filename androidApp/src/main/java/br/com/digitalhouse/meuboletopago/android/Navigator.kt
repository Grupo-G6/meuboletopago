package br.com.digitalhouse.meuboletopago.android

import HomeScreen
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.digitalhouse.meuboletopago.android.delete.DeleteScreen
import br.com.digitalhouse.meuboletopago.android.detail.DetailScreen
import br.com.digitalhouse.meuboletopago.android.login.LoginScreen
import br.com.digitalhouse.meuboletopago.android.passwordrecovery.ChangePassword
import br.com.digitalhouse.meuboletopago.android.passwordrecovery.RecoverPassword
import br.com.digitalhouse.meuboletopago.android.movement.MovementScreen
import br.com.digitalhouse.meuboletopago.android.signup.SignupScreen
import br.com.digitalhouse.meuboletopago.android.edit.*


@Composable
fun Navigator(ctx : Context){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login", builder = {
        composable("login", content = { LoginScreen(navController = navController) })
        composable("home", content = { HomeScreen(navController = navController) })
        composable("movement_page", content = { MovementScreen(navController = navController) })
        composable("edit_page/{id}", content = {
            val id = it.arguments?.getString("id")
            EditScreen(navController = navController, id = id) })
        composable("signup_page", content = { SignupScreen (navController = navController) })
        composable("recover_page", content = { RecoverPassword(navController = navController) })
        composable("password_page", content = { ChangePassword(navController = navController) })
        composable("delete_page/{id}", content = {
            val id = it.arguments?.getString("id")
            DeleteScreen(navController = navController, id= id)
        })
        composable("detail_page/{id}", content = {
            val id = it.arguments?.getString("id")
            DetailScreen(navController = navController, id= id) })
    })
}