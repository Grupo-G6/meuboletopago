package br.com.digitalhouse.meuboletopago.android.signup

import AlertDialogComponent
import androidx.compose.foundation.background
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.android.view.passwordMatches
import br.com.digitalhouse.meuboletopago.api.Api.Companion.id
import br.com.digitalhouse.meuboletopago.util.DataResult

/*TODO VER SE VAMOS USAR O ALERT OU O TOAST NAS TELAS INICIAIS*/
@Composable
fun SignupScreen(navController: NavController) {


    MyApplicationTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            textAlign = TextAlign.Justify,
                            text = "Signup",
                            fontSize = 22.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigate("login") }) {
                            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "")
                        }
                    })
            }
        ) { it ->
            Column(

                Modifier
                    .padding(it)
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .padding(25.dp),

                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {

                val name = remember { mutableStateOf(TextFieldValue()) }
                val email = remember { mutableStateOf(TextFieldValue()) }
                val password = remember { mutableStateOf(TextFieldValue()) }
                val confirmPassword = remember { mutableStateOf(TextFieldValue()) }
//                val emailConfirm = remember { mutableStateOf(TextFieldValue()) }
                val login = remember { mutableStateOf(TextFieldValue()) }
                val showDialog = remember { mutableStateOf(true) }

                val passwordVisible = remember { mutableStateOf(false) }
                val viewModel: SignUpViewModel = viewModel()
                val signUpState by viewModel.signUpState.collectAsState()
//                val isLogged = remember { mutableStateOf(false) }
//                val spacer: Dp = 8.dp


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

                Text(text = "Email")
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = email.value,
                    onValueChange = { email.value = it },
                    label = { Text(text = "") }

                )
//                Text(text = "Confirmar e-mail")
//                OutlinedTextField(
//                    modifier = Modifier.fillMaxWidth(),
//                    value = emailConfirm.value,
//                    onValueChange = { emailConfirm.value = it },
//                    label = { Text(text = "") }
//
//                )
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
                Text(text = "Confirmar senha")
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),

                    value = confirmPassword.value,

                    onValueChange = { confirmPassword.value = it },

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

                if (signUpState is DataResult.Loading) {
                    CircularProgressIndicator()
                } else {
                        if (signUpState is DataResult.Success) {
                            Text(text = "Meuid é $id")
                        navController.navigate("login")

                    } else if (signUpState is DataResult.Error) {
                        Text(text = "O erro é: ${(signUpState as DataResult.Error).error.message}")
                        AlertDialogComponent(
                            showDialog = showDialog.value,
                            message = "Senha inválida!",
                            onDismissRequest = {
                                showDialog.value = !showDialog.value
                                viewModel.defaultState()
                            },
                        )

                    }
                }


                Button(
                    onClick = {
                        val viewModelSign = viewModel.assign(
                            name = name.value.text,
                            email = login.value.text,
                            password = password.value.text
                        )
                        if (passwordMatches(password.value.text, confirmPassword.value.text)) {

                            viewModelSign

//                            navController.navigate("login")

                        }

                    },modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "entrar")
                }
            }
        }
    }
}
fun passwordMatches(password: String, confirmPassword: String) : Boolean {
return password == confirmPassword
    }
@Preview
@Composable
fun SignUpPreview() {
    SignupScreen(navController = NavController(LocalContext.current))
}



