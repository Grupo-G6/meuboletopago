package br.com.digitalhouse.meuboletopago.android.login



import AlertDialogComponent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.api.Api.Companion.token
import br.com.digitalhouse.meuboletopago.util.DataResult


@Composable
fun LoginScreen(navController: NavController) {

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
                /*todo enviar variáveis para o ViewModel */
                val login = remember { mutableStateOf(TextFieldValue()) }
                val password = remember { mutableStateOf(TextFieldValue()) }
                val passwordVisible = remember { mutableStateOf(false) }
                val spacer: Dp = 8.dp
                val showDialog = remember { mutableStateOf(true) }
                val viewModel: LoginViewModel = viewModel()
                val loginState by viewModel.loginState.collectAsState()
                val isLogged = remember{ mutableStateOf(false)}


                Spacer(modifier = Modifier.height(spacer))
                Text(
                    text = "Login",
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.weight(1f))

                Text(text = "E-mail")
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .background( Color(0xFFA1E2C8), CircleShape),
//leadingIcon = começo
                    trailingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "emailIcon") },
                    value = login.value,
                    onValueChange = { login.value = it },
                    label = { Text(text = "") },
                    shape = CircleShape


                )
                Spacer(modifier = Modifier.height(spacer))
                Text(text = "Senha")
               TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
//                        .background( Color(0xFFC6FFF5), CircleShape),

                   shape = CircleShape,

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


                if (loginState is DataResult.Loading) {
                    CircularProgressIndicator()
                } else {
                    if (loginState is DataResult.Success && isLogged.value.not()) {
                        Text(text = "Meu token é $token")
//                        onHomeNavigate.invoke()
                        navController.navigate("home") /*TODO conferir rota*/
                        isLogged.value = true
                    }
                    if (loginState is DataResult.Error) {
//                        Text(text = "O erro é: ${(loginState as DataResult.Error).error.message}")
                        AlertDialogComponent(
                            showDialog = showDialog.value,
                            message = "Login e/ou senha inválida!",
                            onDismissRequest = {showDialog.value = !showDialog.value
                            viewModel.defaultState()
                                               },
                        )

                    }

                        /*TODO direcionar novamente para login e fechar botão ok*/
                    }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement =   Arrangement.SpaceEvenly

                ) {
                    Button(
                        onClick = {
                            viewModel.login(
                                email = login.value.text,
                                password = password.value.text
                            )
                        },
                        modifier = Modifier
                            .width(200.dp)
                        .height(50.dp),
                        shape = RoundedCornerShape(50),
                    )
                    {
                        Text(text = "entrar")
                    }
                }



                    /*TODO: mudar o loginState para Empty */

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement =   Arrangement.SpaceEvenly

                ) {
                    androidx.compose.material3.OutlinedButton(
                        onClick = { navController.navigate("recover_page")
                        },

                        modifier = Modifier.width(220.dp),
//                    shape = RoundedCornerShape(50), // = 50% percent
                        shape = CircleShape
//                        colors = ButtonDefaults.outlinedButtonColors(
//                            contentColor = Color(0xFF59D1A1),
//                            containerColor = Color(0xFF35B884),
//
//                        )
                    ) {
                        Text(text = "Esqueci a senha", color = Color(0xFF369B73))
                    }
                }

                    Spacer(modifier = Modifier.weight(2f))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement =   Arrangement.SpaceEvenly

                ) {
                   TextButton(
                        onClick = {

                            navController.navigate("signup_page")

                        },
                        modifier = Modifier
                            .width(220.dp),


//                        shape = RoundedCornerShape(50),
//                        colors = ButtonDefaults.outlinedButtonColors(
//                            contentColor = Color.Transparent,
//                            containerColor =  Color.Transparent,
//
//                        )
                    )
                    {
                        Text(text = "Ainda não tem cadastro? Clique aqui!", color = Color(0xFF009688), textAlign = TextAlign.Center)
//                        Text(text = "Clique aqui!", color = Color(0xFF009688))
                    }
                }

                }
            }
        }
    }




@Preview
@Composable
fun DefaultPreview() {
    LoginScreen(navController = NavController(LocalContext.current))

}
//preview não pode ser usado com viewModel


























