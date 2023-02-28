package br.com.digitalhouse.meuboletopago.android

import HomeScreen
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.digitalhouse.meuboletopago.android.edit.EditScreen
import br.com.digitalhouse.meuboletopago.android.login.LoginScreen
import br.com.digitalhouse.meuboletopago.android.screen.DetailScreen
import br.com.digitalhouse.meuboletopago.android.view.*


//@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Navigator(ctx : Context){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login", builder = {
        composable("login", content = { LoginScreen(navController = navController) })
        composable("home", content = {

            HomeScreen(navController = navController, onItemDetail = {navController.navigate("home/$it")}) })
        composable("create_movement_page", content = { CreateMovementScreen(navController = navController) })
        composable("edit_page", content = { EditScreen(navController = navController) })
        composable("transaction_page/{id}", content = {
            val id = it.arguments?.getString("id")
            TransactionScreen(id ?: "0", navController = navController) })
        composable("signup_page", content = { SignupScreen (navController = navController) })
        composable("recover_page", content = { RecoverPassword(navController = navController) })
        composable("delete_page", content = { DeleteScreen(navController = navController) })
        composable("detail_page", content = { DetailScreen (navController = navController) })

    })
}