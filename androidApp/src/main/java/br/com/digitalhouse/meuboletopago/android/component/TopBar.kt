package br.com.digitalhouse.meuboletopago.android.component

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterTopBar(title: String, navController: NavController) {
    CenterAlignedTopAppBar(
        title = { Text(title, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF369B73)) },
        actions = {
            IconButton(onClick = { navController.navigate("movement") }) {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "Criar Movimentação",
                    tint = Color(0xFF369B73)
                )
            }
        }
    )
}


@Composable
fun TopBar(title: String = "", navController: NavController){
    TopAppBar(
        navigationIcon = { IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                Icons.Filled.ArrowBack,
                contentDescription = "Back",
                tint = Color.White
            )
        }
        },
        title = { Text(title, fontSize = 20.sp, color = Color.White) },
        backgroundColor = Color(0xFF369B73),
        contentColor = Color.White
    )
}

@Preview
@Composable
fun CenterTopBar_Preview() {
    CenterTopBar(title = "Controle de Despesas", navController = NavController(LocalContext.current))
}