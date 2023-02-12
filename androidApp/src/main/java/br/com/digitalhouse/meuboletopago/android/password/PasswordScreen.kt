package br.com.digitalhouse.meuboletopago.android.password

import AlertDialogComponent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
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
import br.com.digitalhouse.meuboletopago.model.Login

@Composable
fun PasswordScreen(navController: NavController)  {
    val spacer: Dp = 16.dp
    val password = remember { mutableStateOf(TextFieldValue()) }
    val password2 = remember { mutableStateOf(TextFieldValue()) }
    val passwordVisible = remember { mutableStateOf(false) }
    val passwordVisible2 = remember { mutableStateOf(false) }
    val showDialog = remember { mutableStateOf(false) }
    MyApplicationTheme() {
        Scaffold (
            topBar = { TopBar(title = "Recuperar Senha", navController = navController) }
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(it)
                    .fillMaxWidth()
                    .padding(spacer)) {
                item {
                    Spacer(modifier = Modifier.height(spacer))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(spacer)
                    ){
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
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = password2.value,
                            onValueChange = { password2.value = it },
                            label = {
                                Text(
                                    text = "Confirmar Senha",
                                    color = (MaterialTheme.colors.primaryVariant)
                                )
                            },
                            visualTransformation =
                            if (passwordVisible2.value.not()) PasswordVisualTransformation()
                            else VisualTransformation.None,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            trailingIcon = {
                                val iconPassword =
                                    if (passwordVisible2.value.not()) Icons.Filled.Visibility
                                    else Icons.Filled.VisibilityOff
                                val description =
                                    if (passwordVisible2.value.not()) "Invisível"
                                    else "Visível"
                                IconButton(
                                    onClick = { passwordVisible2.value = !passwordVisible2.value }
                                ) {
                                    Icon(
                                        imageVector = iconPassword,
                                        contentDescription = description,
                                        tint = (MaterialTheme.colors.primaryVariant)
                                    )
                                }
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(spacer))
                    Button(
                        onClick = {
                            if (password.value == password2.value) {
                                Login("", password.value.text)
                                navController.navigate("login")
                            }else {
                                showDialog.value = true
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(spacer)
                    ) {
                        Text(text = "Salvar")
                    }
                    AlertDialogComponent(
                        showDialog = showDialog.value,
                        message = "Senhas inseridas não são identicas!",
                        onDismissRequest = { showDialog.value = false }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PasswordScreen_Preview() {
    PasswordScreen(navController = NavController(LocalContext.current))
}