package br.com.digitalhouse.meuboletopago.android.view

import AlertDialogComponent
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.*
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme

@Composable
fun RecoverPassword(navController: NavController){
    val context = LocalContext.current
    val showDialog = remember { mutableStateOf(false) }
    MyApplicationTheme {
        Scaffold(
            topBar =   { TopAppBar(
                title = { Text(
                    textAlign = TextAlign.Justify,
                    text = "Recuperação de senha",
                    fontSize = 22.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("login")}) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
                    }
                })
            }
        ) {
            Column(modifier = Modifier.padding(it)) {
                val visible = remember { mutableStateOf(false) }
                val passwordVisible = remember { mutableStateOf(false) }
                val email = remember { mutableStateOf(TextFieldValue()) }
                val token = remember { mutableStateOf(TextFieldValue()) }
                val newPassword = remember { mutableStateOf(TextFieldValue()) }
                val confirmNewPassword = remember { mutableStateOf(TextFieldValue()) }
                AnimatedVisibility(visible = !visible.value ) {
                    Column(modifier = Modifier
                        .padding(25.dp)
                        .background(Color.White)
                        .fillMaxWidth()
                        .fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center) {
                        Text(text = "Insira o e-mail cadastrado.",
                            textAlign = TextAlign.Start,
                            fontSize = 18.sp)
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = email.value,
                            onValueChange = { email.value = it },
                            label = {
                                Text(text = "E-mail")
                            }
                        )
                        Button(modifier = Modifier.padding(16.dp),
                            onClick = {
                                Toast.makeText(context,
                                    "O token foi enviado, cheque seu e-mail",
                                    Toast.LENGTH_SHORT).show()
                                visible.value = !visible.value},
                            colors = ButtonDefaults.buttonColors(MaterialTheme.colors.primary)){
                            Text(text = "Enviar e-mail",
                                color = Color.White)
                        }
                    }
                }
                AnimatedVisibility(visible = visible.value)
                {
                    AlertDialogComponent(
                        showDialog = showDialog.value,
                        message = "Senhas não são correspondentes. Tente novamente.",
                        onDismissRequest = { showDialog.value = !showDialog.value })
                    Column(modifier = Modifier
                        .padding(25.dp)
                        .background(Color.White)
                        .fillMaxWidth()
                        .fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center){
                        Text(text = "Insira o token enviado no e-mail e cadastre sua nova senha",
                            textAlign = TextAlign.Start,
                            fontSize = 18.sp)
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = token.value,
                            onValueChange = { token.value = it },
                            label = {
                                Text(text = "Token")
                            }
                        )
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = newPassword.value,
                            onValueChange = { newPassword.value = it },
                            label = { Text(text = "Nova senha") },
                            visualTransformation = if (passwordVisible.value.not()) PasswordVisualTransformation() else VisualTransformation.None,
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
                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = confirmNewPassword.value,
                            onValueChange = { confirmNewPassword.value = it },
                            label = { Text(text = "Confirme sua senha") },
                            visualTransformation = if (passwordVisible.value.not()) PasswordVisualTransformation() else VisualTransformation.None,
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
                        Button(modifier = Modifier.padding(16.dp),
                            onClick = { if (passwordMatches(newPassword.value.text, confirmNewPassword.value.text)){
                                Toast.makeText(context,
                                    "Senha alterada, faça o login.",
                                    Toast.LENGTH_SHORT).show()
                            } else {
                                showDialog.value = !showDialog.value
                            }
                            },
                            colors = ButtonDefaults.buttonColors(MaterialTheme.colors.primary)){
                            Text(text = "Mudar senha",
                                color = Color.White)
                        }
                        Button(
                            onClick = {/*openDialog.value = true*/
                                visible.value = !visible.value},
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)  )
                        {
                            Text(
                                text = "Reenviar e-mail",
                                color = MaterialTheme.colors.primary
                            )
                        }
                    }
                }
            }
        }
    }
}

fun passwordMatches(password: String, checkPassword: String) : Boolean {
    return password == checkPassword
}

