package br.com.digitalhouse.meuboletopago.android

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import br.com.digitalhouse.meuboletopago.android.components.CenterTopBar


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun TransactionScreen(id: String, navController: NavController?) {
        MyApplicationTheme {
            Scaffold(
                topBar = {
                    if (navController != null) {
                        CenterTopBar(
                            title = "Controle de Despesas",
                            navController = navController

                        )
                    }
                }
            ) { _ ->
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Meu id é $id")
                    Button(onClick = { navController?.popBackStack() }) {
                        Text(text = "Voltar")
                    }
                    Button(onClick = { navController?.navigate("/edit_page") }) {
                        Text(text = "Ir para proxima tela")
                    }
                }
            }
        }
    }

    @Preview
    @Composable
    fun TransactionScreen_Preview() = TransactionScreen("1", null)



