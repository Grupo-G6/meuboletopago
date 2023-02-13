package br.com.digitalhouse.meuboletopago.android.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
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
import br.com.digitalhouse.meuboletopago.android.R


//class SignupScreen(navController: NavHostController) : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MyApplicationTheme {
//                Surface(
//
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//
//                ) {
//                    SignupView(navController = NavController(LocalContext.current))
//                }
//            }
//        }
//    }
//}


@Composable
fun SignupView(navController: NavController) {
    val context = LocalContext.current
    val showDialog = remember { mutableStateOf(false) }
    val name = remember { mutableStateOf(TextFieldValue()) }
    val lastName = remember { mutableStateOf(TextFieldValue()) }
    val email = remember { mutableStateOf(TextFieldValue()) }
    val emailConfirm = remember { mutableStateOf(TextFieldValue()) }
    MyApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(

                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White) //conferir linhas acontentColor = Color.White,
                    .padding(25.dp),

                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                //VARIÁVEIS
                val login = remember { mutableStateOf(TextFieldValue()) }
                val password = remember { mutableStateOf(TextFieldValue()) }
                val passwordVisible = remember { mutableStateOf(false) }

                Image(
                    painter = painterResource(id = R.drawable.meu_boleto_pago_vector),
                    contentDescription = "Meu Boleto Pago",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Cadastro",
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp,
                  /*  color = MaterialTheme.colors.primary */
                )
                Spacer(modifier = Modifier.height(16.dp))

//
                Text(text = "Nome")
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = name.value,
                    onValueChange = { name.value = it },
                    label = { Text(text = "") }

                )
                Text(text = "Sobrenome")
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = lastName.value,
                    onValueChange = { lastName.value = it },
                    label = { Text(text = "") }

                )
                Text(text = "Email")
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = email.value,
                    onValueChange = { login.value = it },
                    label = { Text(text = "") }

                )
                Text(text = "Confirmar e-mail")
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = emailConfirm.value,
                    onValueChange = { login.value = it },
                    label = { Text(text = "") }

                )
                Text(text = "Senha")
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),

                    value = password.value,

                    onValueChange = { password.value = it },

                    label = { Text(text = "") },

                    visualTransformation = if (passwordVisible.value.not()) PasswordVisualTransformation() else VisualTransformation.None,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        val iconPassword =
                            if (passwordVisible.value.not()) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                        val description =
                            if (passwordVisible.value.not()) "Invisível" else "Visível"
                        IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                            Icon(imageVector = iconPassword, contentDescription = description)
                        }
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    modifier = Modifier.padding(16.dp),
                    onClick = {

                        Toast.makeText(
                            context,
                            "Cadastro realizado com sucesso!",
                            Toast.LENGTH_SHORT
                        ).show()

                        showDialog.value = !showDialog.value
                        navController.navigate("home")
                    },

                    colors = ButtonDefaults.buttonColors(MaterialTheme.colors.primary)
                ) {
                    Text(
                        text = "Cadastrar",
                        color = Color.White
                    )
                }
            }
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



