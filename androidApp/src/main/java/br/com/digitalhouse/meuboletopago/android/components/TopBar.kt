package br.com.digitalhouse.meuboletopago.android.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.*
import androidx.compose.material3.ListItemDefaults.contentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(title: String, navController: NavController) {

    MyApplicationTheme {
        Scaffold(
//            Modifier.padding(1.dp),
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Top App Bar")
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(Icons.Filled.ArrowBack, "backIcon")
                        }
                    },
//                    backgroundColor = MaterialTheme.colors.primary,
//                    contentColor = Color.Transparent,
//                    elevation = 10.dp
                )
            },
            content = {}
//                Column(
//                    modifier = Modifier
//                        .padding(20.dp)
//                        .fillMaxSize(),
//
////                        .background(Color(0xff8d6e63)),
//
//                    verticalArrangement = Arrangement.Bottom,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
////                Text(
////                    text = "Content of the page",
////                    fontSize = 30.sp,
////                    color = Color.White
////                )
//                    FloatingActionButton(onClick = { navController.navigate("movement_page") }, containerColor = MaterialTheme.colors.primary, modifier = Modifier.size(70.dp), shape = RoundedCornerShape(40.dp), contentColor = Color.White){
//                        Icon(imageVector = Icons.Default.Add, contentDescription = "fab icon")
//                    }
//                }

//
//            }
        )
    }
}

@Composable
fun CenterTopBar(title: String, navController: NavController){
    MyApplicationTheme {

    TopAppBar(
        navigationIcon = { IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                Icons.Filled.ArrowBack,
                contentDescription = "Back")
        }
        },
        title = { Text(title) }
    )
}}

@Preview
@Composable
fun CenterTopBar_Preview() {
    CenterTopBar(title = "Movimentação", navController = NavController((LocalContext.current)))
}