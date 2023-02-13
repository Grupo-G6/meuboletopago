package br.com.digitalhouse.meuboletopago.android.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme


class SignupScreen(navController: NavHostController) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(

                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background

                ) {
                    SignupView(navController = NavController(LocalContext.current))
                }
            }
        }
    }
}


@Composable
fun SignupView(navController: NavController) {
    Column(

        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.White) //conferir linhas a
            .padding(25.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //VARIÁVEIS
        val login = remember { mutableStateOf(TextFieldValue()) }
        val password = remember { mutableStateOf(TextFieldValue()) }
        val passwordVisible = remember { mutableStateOf(false) }


        Text(text = "MeuBoletoPago", fontWeight = FontWeight.Bold, fontSize = 32.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Cadastro", fontWeight = FontWeight.Normal, fontSize = 25.sp)
        Spacer(modifier = Modifier.height(16.dp))


//
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = login.value,
            onValueChange = { login.value = it },
            label = { Text(text = "Nome") }

        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = login.value,
            onValueChange = { login.value = it },
            label = { Text(text = "Sobrenome") }

        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = login.value,
            onValueChange = { login.value = it },
            label = { Text(text = "E-mail") }

        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = login.value,
            onValueChange = { login.value = it },
            label = { Text(text = "Confirmar e-mail") }

        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),

            value = password.value,

            onValueChange = { password.value = it },

            label = { Text(text = "password") },

            visualTransformation =  if (passwordVisible.value.not()) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val iconPassword =
                    if (passwordVisible.value.not()) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                val description = if (passwordVisible.value.not()) "Invisível" else "Visível"
                IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                    Icon(imageVector = iconPassword, contentDescription = description)
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {/*openDialog.value = true*/}, modifier = Modifier.fillMaxWidth()){
            Text(text = "Cadastrar")
        }
    }
}
//
//@Preview
//@Composable
//fun SignupPreview() {
//    MyApplicationTheme {
//        Surface(
//            color = Color.White,
//            modifier = Modifier.fillMaxSize()
//        ) {
//            SignupView(navController = NavController(LocalContext.current))
//        }
//    }
//}



