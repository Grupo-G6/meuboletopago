package br.com.digitalhouse.meuboletopago.android.passwordrecovery

import AlertDialogComponent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.*
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.android.components.LoadingIndicator
import br.com.digitalhouse.meuboletopago.util.DataResult

@Composable
fun ChangePassword(navController: NavController){
    val context = LocalContext.current
    val showDialog = remember { mutableStateOf(false) }
    val errorDialog = remember { mutableStateOf(false)}
    MyApplicationTheme {
        Scaffold(
            topBar =   { TopAppBar(
                backgroundColor = MaterialTheme.colors.primaryVariant,
                title = { Text(
                    textAlign = TextAlign.Justify,
                    text = "Mudança de senha",
                    fontSize = 22.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("recover_page")}) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Voltar à tela de recuperação")
                    }
                })
            }
        ) {
            Column(modifier = Modifier.padding(it)) {
                val passwordVisible = remember { mutableStateOf(false) }
                val confirmPasswordVisible = remember { mutableStateOf(false) }
                val passwordChanged = remember { mutableStateOf(false) }
                val token = remember { mutableStateOf(TextFieldValue()) }
                val newPassword = remember { mutableStateOf(TextFieldValue()) }
                val confirmNewPassword = remember { mutableStateOf(TextFieldValue()) }
                val viewModel : ChangePasswordViewModel = viewModel()
                val sendState by viewModel.changedState.collectAsState()
                AlertDialogComponent(
                    showDialog = showDialog.value,
                    message = "Senhas não são correspondentes. Tente novamente.",
                    onDismissRequest = { showDialog.value = !showDialog.value }
                )
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
                        visualTransformation = if (confirmPasswordVisible.value.not()) PasswordVisualTransformation() else VisualTransformation.None,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        trailingIcon = {
                            val iconPassword =
                                if (confirmPasswordVisible.value.not()) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                            val description = if (confirmPasswordVisible.value.not()) "Invisível" else "Visível"
                            IconButton(onClick = { confirmPasswordVisible.value = !confirmPasswordVisible.value }) {
                                Icon(imageVector = iconPassword, contentDescription = description)
                            }
                        }
                    )
                    if(sendState is DataResult.Loading){
                        LoadingIndicator()
                    } else {
                        if (sendState is DataResult.Send){
                            Toast.makeText(context,
                                "Senha alterada, faça o login.",
                                Toast.LENGTH_SHORT).show()
                            passwordChanged.value = true
                            errorDialog.value = false
                            token.value = TextFieldValue("")
                            newPassword.value = TextFieldValue("")
                            confirmNewPassword.value = TextFieldValue("")
                            viewModel.setDefaultState()
                        }
                        if (sendState is DataResult.Error){
                            errorDialog.value = true
                            AlertDialogComponent(
                                showDialog = errorDialog.value,
                                message = "Não foi possível mudar a senha, tente novamente.",
                                onDismissRequest = {
                                    errorDialog.value = false
                                    token.value = TextFieldValue("")
                                    newPassword.value = TextFieldValue("")
                                    confirmNewPassword.value = TextFieldValue("")
                                    viewModel.setDefaultState()
                                })
                        }
                        Button(modifier = Modifier.padding(16.dp),
                            onClick = { if (passwordMatches(newPassword.value.text, confirmNewPassword.value.text)){
                                    viewModel.changePassword(token.value.text, newPassword.value.text)
                            } else {
                                    showDialog.value = !showDialog.value
                                }
                            },
                            colors = ButtonDefaults.buttonColors(MaterialTheme.colors.primary)){
                            Text(text = "Mudar senha",
                                color =  MaterialTheme.colors.primaryVariant)
                        }
                        Button(
                            onClick = {
                                        navController.popBackStack()
                                        passwordChanged.value = false
                                      },
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent))
                        {
                            Text(
                                text = "Reenviar e-mail",
                                color = MaterialTheme.colors.primary
                            )
                        }
                        if(passwordChanged.value){
                            Button(
                                onClick = { navController.navigate("login") },
                                modifier = Modifier.fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary))
                            {
                                Text(
                                    text = "Ir para login",
                                    color =  MaterialTheme.colors.primaryVariant,
                                )
                            }
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

