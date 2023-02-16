//package br.com.digitalhouse.dhwallet.android.transactions
//
//import android.annotation.SuppressLint
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.material.Button
//import androidx.compose.material.Scaffold
//import androidx.compose.material.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.navigation.NavHostController
////import br.com.digitalhouse.dhwallet.android.MyApplicationTheme
////import br.com.digitalhouse.dhwallet.android.component.CenterTopBar
//import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
//
//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@Composable
//fun PTransactionScreen(id: String, navHostController: NavHostController?) {
//    MyApplicationTheme {
//        Scaffold(
//            topBar = {
//
//            }
//        ) { _ ->
//            Column(
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Text(text = "Meu id é $id")
//                Button(onClick = { navHostController?.popBackStack() }) {
//                    Text(text = "Voltar")
//                }
//                Button(onClick = { navHostController?.navigate("detalhe/Anderson") }) {
//                    Text(text = "Ir para proxima tela")
//                }
//            }
//        }
//    }
//}
//
//@Preview
//@Composable
//fun TransactionScreen_Preview() = PTransactionScreen("1", null)
