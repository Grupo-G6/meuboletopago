package br.com.digitalhouse.meuboletopago.android.screen

import AlertDialogComponent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.android.R
import br.com.digitalhouse.meuboletopago.android.view.Detalhe
import br.com.digitalhouse.meuboletopago.model.Login

class RecoverPassword : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Detalhe()
                }
            }
        }
    }
}
@Composable
fun Recover() {
    var state by remember { mutableStateOf(true) }
    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        TopAppBar(
            modifier = Modifier.fillMaxWidth(),
            title = {
                Text(text = "Recuperar senha")
            },
//            navigationIcon = {
//                IconButton(onClick = { /*TODO*/ }) {
//                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
//                }
//            },
//            backgroundColor = Color.Blue,
            contentColor = Color.White,
            elevation = 8.dp )

                val login = remember { mutableStateOf(TextFieldValue()) }
                val password = remember { mutableStateOf(TextFieldValue()) }
                val passwordVisible = remember { mutableStateOf(false) }
                val showDialog = remember { mutableStateOf(false) }



                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = password.value,
                    onValueChange = { password.value = it },
                    label = { Text(text = "Senha") },
                    visualTransformation = if (passwordVisible.value.not()) PasswordVisualTransformation() else VisualTransformation.None,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    trailingIcon = {
                        val icon =
                            if (passwordVisible.value.not()) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                        val description =
                            if (passwordVisible.value.not()) "Mostrar senha" else "Esconder senha"
                        IconButton(
                            onClick = { passwordVisible.value = passwordVisible.value.not() }) {
                            Icon(imageVector = icon, contentDescription = description)
                        }
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = password.value,
            onValueChange = { password.value = it },
            label = { Text(text = "Confirmar senha") },
            visualTransformation = if (passwordVisible.value.not()) PasswordVisualTransformation() else VisualTransformation.None,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val icon =
                    if (passwordVisible.value.not()) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                val description =
                    if (passwordVisible.value.not()) "Mostrar senha" else "Esconder senha"
                IconButton(
                    onClick = { passwordVisible.value = passwordVisible.value.not() }) {
                    Icon(imageVector = icon, contentDescription = description)
                }
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    val loginUser = Login(login = login.value.text, senha = password.value.text)
                    if (loginUser.validator()) {
//                        onHomeNavigate.invoke()
//                        navController.navigate("home")
                    } else {
                        showDialog.value = true
                    }
                }, modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Entrar")
                }
                AlertDialogComponent(
                    showDialog = showDialog.value,
                    message = "Senhas não coincidem!",
                    onDismissRequest = { showDialog.value = false }
                )
                Spacer(modifier = Modifier.height(256.dp))

            }
        }

@Preview
@Composable
fun RecoverPassword_Preview() {
    MyApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Recover()
        }
    }
}