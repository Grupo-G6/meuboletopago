package br.com.digitalhouse.meuboletopago.android.components

import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterTopBar(title: String, navController: NavController) {
    CenterAlignedTopAppBar(
        title = { Text(title) },
        actions = {
            IconButton(onClick = { navController.navigate("movement_page") }) {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "Criar Movimentação"
                )
            }
        },
    )
}

@Composable
fun TopBar(title: String = "", navController: NavController){
    TopAppBar(
        navigationIcon = { IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                Icons.Filled.ArrowBack,
                contentDescription = "Back")
        }
        },
        title = { Text(title) }
    )
}

//@Preview
//@Composable
//fun CenterTopBar_Preview() {
//    CenterTopBar(title = "Movimentação", navController = NavController)
//}