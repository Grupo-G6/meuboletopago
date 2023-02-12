package br.com.digitalhouse.meuboletopago.android.signup

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.android.component.TopBar

@Composable
fun SignupScreen(navController: NavController) {
    val spacer: Dp = 8.dp
    val login = remember { mutableStateOf(TextFieldValue()) }
    val password = remember { mutableStateOf(TextFieldValue()) }
    val passwordVisible = remember { mutableStateOf(false) }
    MyApplicationTheme() {
        Scaffold(
            topBar = { TopBar(title = "Cadastro", navController = navController) }
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(it)
                    .padding(spacer)
            ) {
                item{
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = login.value,
                        onValueChange = { login.value = it },
                        label = {
                            Text(
                                text = "Nome",
                                color = (MaterialTheme.colors.primaryVariant)
                            )
                        }
                    )
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = login.value,
                        onValueChange = { login.value = it },
                        label = {
                            Text(
                                text = "Sobrenome",
                                color = (MaterialTheme.colors.primaryVariant)
                            )
                        }
                    )
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = login.value,
                        onValueChange = { login.value = it },
                        label = {
                            Text(
                                text = "E-mail",
                                color = (MaterialTheme.colors.primaryVariant)
                            )
                        }
                    )
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = login.value,
                        onValueChange = { login.value = it },
                        label = {
                            Text(
                                text = "Confirmar E-mail",
                                color = (MaterialTheme.colors.primaryVariant)
                            )
                        }
                    )
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = password.value,
                        onValueChange = { password.value = it },
                        label = {
                            Text(
                                text = "Senha",
                                color = (MaterialTheme.colors.primaryVariant)
                            )
                        },
                        visualTransformation =
                            if (passwordVisible.value.not()) PasswordVisualTransformation()
                            else VisualTransformation.None,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        trailingIcon = {
                            val iconPassword =
                                if (passwordVisible.value.not()) Icons.Filled.Visibility
                                else Icons.Filled.VisibilityOff
                            val description =
                                if (passwordVisible.value.not()) "Invisível"
                                else "Visível"
                            IconButton(
                                onClick = { passwordVisible.value = !passwordVisible.value }
                            ) {
                                Icon(
                                    imageVector = iconPassword,
                                    contentDescription = description,
                                    tint = (MaterialTheme.colors.primaryVariant)
                                )
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(spacer))
                    Button(
                        onClick = {navController.navigate("login")},
                        modifier = Modifier.fillMaxWidth()
                    ){
                        Text(text = "Cadastrar")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SignupScreen_Preview() {
    SignupScreen(navController = NavController(LocalContext.current))
}