package br.com.digitalhouse.meuboletopago.android.components.cards

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldSample(navController: NavController, title: String) {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    MyApplicationTheme {
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                TopAppBar(
                    title = { Text(title) },
                    backgroundColor = MaterialTheme.colors.primary,
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() } ) {
                           Icon(
                                Icons.Filled.ArrowBack,
                                contentDescription = "Back",
//                                color = Color.White,
                            )
                        }
                    }, elevation = 10.dp,
                    contentColor = Color.White,
                )
            },

            floatingActionButtonPosition = FabPosition.Center,
            floatingActionButton = {
                FloatingActionButton(onClick = {navController.navigate("movement_page")}, contentColor = Color.White, backgroundColor = MaterialTheme.colors.primary ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "fab icon")
                }
            },
            drawerContent = { Text(text = "Drawer Menu 1") },
            content = { Text("Content") },
            bottomBar =  {BottomBar()}
//            bottomBar = { BottomAppBar(backgroundColor = MaterialTheme.colors.primary) { Text("Bottom App Bar") } }
        )
    }
}

fun Icon(arrowBack: ImageVector, contentDescription: String, color: Color) {

}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ScaffoldWithTopBar(backPressed: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row() {
                        Text(
                            text = "Title 1",
                            fontSize = 30.sp,
                            color = Color.Red
                        )
                        Text(
                            text = " Title 2",
                            fontSize = 30.sp,
                            color = Color.White
                        )

                    }
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White,
                elevation = 10.dp
            )
        }, content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xff8d6e63)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Content of the page",
                    fontSize = 30.sp,
                    color = Color.White
                )
            }

        }
    )
}




@Preview
@Composable
fun ScaffoldPreview() {
    ScaffoldSample(navController= NavController(LocalContext.current), title = "")
}

