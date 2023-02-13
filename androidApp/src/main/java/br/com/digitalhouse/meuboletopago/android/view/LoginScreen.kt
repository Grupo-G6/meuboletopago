package br.com.digitalhouse.meuboletopago.android.login

import AlertDialogComponent
import android.media.Image
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
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
import br.com.digitalhouse.meuboletopago.android.R
import androidx.navigation.NavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.model.Login
//import kotlinx.coroutines.NonCancellable.message
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context

@Composable
fun LoginScreen(navController: NavController) {
    val spacer: Dp = 8.dp
    MyApplicationTheme() {

        Surface(modifier = Modifier.fillMaxSize()) {

            Column(
                modifier = Modifier
                .padding(25.dp)
                .background(Color.White)
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center)

             {
                //VARIÁVEIS
                val login = remember { mutableStateOf(TextFieldValue()) }
                val password = remember { mutableStateOf(TextFieldValue()) }
                val passwordVisible = remember { mutableStateOf(false) }
                val showDialog = remember { mutableStateOf(false) }
                val mensagem = remember { mutableStateOf("") }

               Image(
                    painter = painterResource(id = R.drawable.meu_boleto_pago),
                    contentDescription = "Meu Boleto Pago",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                )
                Spacer(modifier = Modifier.height(spacer))
                Text(
                    text = "Login",
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp,
                    textAlign = TextAlign.Center
                    )
                Spacer(modifier = Modifier.height(spacer))

//        ver diferença textfield, outline and textfieldValue - VER MATERIAL DESIGN
//        USUÁRIO
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
                 Button(onClick = {
                    val loginUser = Login(
                        loginEnter = login.value.text,
                        senha = password.value.text
                    )
                    mensagem.value = if (loginUser.validator()) {
                        navController.navigate("home")
                        "Login executado com sucesso!  Seus boletos vão ter um final feliz :)"
                    } else {

                        "Ops! Login ou senha inválida :("
                    }
                    showDialog.value = true

                }, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "entrar")
                }
                AlertDialogComponent(
                    showDialog = showDialog.value,
                    message = mensagem.value,
                    onDismissRequest = { showDialog.value = false }

                )
                Button(
                    onClick = {

                        navController.navigate("recover_page")

                    }, modifier =  Modifier.fillMaxWidth())
                {
                    Text(text = "Esqueci a senha")
                }

                Spacer(modifier = Modifier.height(96.dp))



                    Button(
                        onClick = {

                        navController.navigate("signup_page")

                        }, modifier =  Modifier.fillMaxWidth())
                    {
                        Text(text = "Ainda não tem cadastro? Clique aqui")
                    }



                }
            }
        }
    }






//@Preview
//@Composable
//fun LoginScreen_Preview(navController: NavController?) {
//    LoginScreen(navController = NavController(LocalContext.current))
//}