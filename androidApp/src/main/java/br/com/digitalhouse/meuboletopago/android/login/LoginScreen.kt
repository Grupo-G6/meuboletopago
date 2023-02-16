package br.com.digitalhouse.meuboletopago.android.login



import AlertDialogComponent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.android.view.passwordMatches
import br.com.digitalhouse.meuboletopago.api.Api.Companion.token
import br.com.digitalhouse.meuboletopago.util.DataResult


@Composable
fun LoginScreen(navController: NavController) {
    val spacer: Dp = 8.dp
    val context = LocalContext.current
    val showDialog = remember { mutableStateOf(false) }
    MyApplicationTheme() {

        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .padding(25.dp)
                    .background(Color.White)
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            )

            {
                //VARIÁVEIS
                val login = remember { mutableStateOf(TextFieldValue()) }
                val mensagem = remember { mutableStateOf("") }
                val password = remember { mutableStateOf(TextFieldValue()) }
                val passwordVisible = remember { mutableStateOf(false) }
                val showDialog = remember { mutableStateOf(false) }
                val viewModel: LoginViewModel = viewModel()
                val loginState by viewModel.loginState.collectAsState()


                Spacer(modifier = Modifier.height(spacer))
                Text(
                    text = "Login",
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(spacer))

                Text(text = "E-mail")
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = login.value,
                    onValueChange = { login.value = it },
                    label = { Text(text = "") }

                )
                Spacer(modifier = Modifier.height(spacer))
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

                if (loginState is DataResult.Success) {
                    Text(text = "Meu token é $token")
                    navController.navigate("home")
                }


                else(loginState is DataResult.Error) {
                    showDialog.value = true
                }

                Button(
                    modifier = Modifier.padding(16.dp),
                    onClick = {
                        viewModel.login(
                            login.value.text,
                            password.value.text
                        )
                        Toast.makeText(
                            context,
                            "Cadastro realizado com sucesso!",
                            Toast.LENGTH_SHORT
                        ).show()
                        navController.navigate("home")
                    },

                    colors = ButtonDefaults.buttonColors(MaterialTheme.colors.primary)
                ) {
                    Text(
                        text = "Cadastrar",
                        color = Color.White
                    )


                }
//                if (loginState is DataResult.Loading) {
//                    CircularProgressIndicator()
//                    if() {




//
//                Button(
//                    modifier = Modifier.padding(16.dp),
//                    onClick = {

//                        if /*(loginState is DataResult.Loading) {
//                                CircularProgressIndicator()
//                            } else {
//                                if*/ (loginState is DataResult.Success) {
////                            mensagem.value = "Login com sucesso"
//                            navController.navigate("home")
//                        } else (loginState is DataResult.Error) {
//                            showDialog.value = true
//                            mensagem.value = "Ops! Login ou senha inválida :("
//
//                        }
//
//
//                    },
//
//                )
//                {
//                    Text(text = "entrar")
//                }


                    AlertDialogComponent(
                        showDialog = showDialog.value,
                        message = mensagem.value,
                        onDismissRequest = { showDialog.value = false },
//

                    )
                    Button(
                        onClick = {

                            navController.navigate("recover_page")

                        }, modifier = Modifier.fillMaxWidth()
                    )
                    {
                        Text(text = "Esqueci a senha")
                    }

                    Spacer(modifier = Modifier.height(96.dp))
                    Button(
                        onClick = {

                            navController.navigate("signup_page")

                        }, modifier = Modifier.fillMaxWidth()
                    )
                    {
                        Text(text = "Ainda não tem cadastro? Clique aqui")
                    }

                }
            }
        }
    }

private operator fun Boolean.invoke(value: Any) {

}


//private operator fun <T> Comparable<T>.invoke(value: Any) {
//
//}











