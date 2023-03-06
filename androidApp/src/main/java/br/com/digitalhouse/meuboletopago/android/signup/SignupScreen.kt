package br.com.digitalhouse.meuboletopago.android.signup

import AlertDialogComponent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
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
import br.com.digitalhouse.meuboletopago.api.Api
import br.com.digitalhouse.meuboletopago.model.SignUp
import br.com.digitalhouse.meuboletopago.util.DataResult

/*TODO VER SE VAMOS USAR O ALERT OU O TOAST NAS TELAS INICIAIS*/
@Composable
fun SignupScreen(navController: NavController) {
    MyApplicationTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    backgroundColor = MaterialTheme.colors.primaryVariant,
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
        ) {
            Column(

                Modifier
                    .padding(it)
                    .fillMaxWidth()
                    .background(color = Color.White)
                    .padding(25.dp),

                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {

                val nome = remember { mutableStateOf(TextFieldValue()) }
                val email = remember { mutableStateOf(TextFieldValue()) }
                val senha = remember { mutableStateOf(TextFieldValue()) }
                val context = LocalContext.current
                val showDialog = remember { mutableStateOf(true) }
                val passwordVisible = remember { mutableStateOf(false) }
                val viewModel: SignUpViewModel = viewModel()
                val signUpState by viewModel.signUpState.collectAsState()
                val isLogged = remember { mutableStateOf(false) }
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
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp),
                    shape = RoundedCornerShape(20.dp),
                    value = nome.value,
                    onValueChange = { nome.value = it },
                    label = { Text(text = "") }

                )

                Text(text = "Email")
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp),
                    shape = RoundedCornerShape(20.dp),
                    value = email.value,
                    onValueChange = { email.value = it },
                    label = { Text(text = "") },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "emailIcon"
                        )
                    }

                )

                Text(text = "Senha")
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp),
                    shape = RoundedCornerShape(20.dp),
                    value = senha.value,


                    onValueChange = { senha.value = it },

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
                if (signUpState is DataResult.Loading) {
                    CircularProgressIndicator()
                } else {
                    if (signUpState is DataResult.Success /*&& isLogged.value.not()*/) {
                        isLogged.value = true
                        navController.navigate("login")
                         viewModel.defaultState()
                    }
                    if (signUpState is DataResult.Error) {
                        Text(text = "O erro é: ${(signUpState as DataResult.Error).error.message}")
                        AlertDialogComponent(
                            showDialog = showDialog.value,
                            message = "Cadastro não realizado!",
                            onDismissRequest = {
                                showDialog.value = !showDialog.value
                                viewModel.defaultState()
                            },
                        )
                    }
                    Button(
                        onClick = {
                            viewModel.assign(
                                signup = SignUp(
                                    name = nome.value.text,
                                    email = email.value.text,
                                    password = senha.value.text,
                                )
                            )
                            Toast.makeText(context,
                                "Cadastro realizado com sucesso!",
                                Toast.LENGTH_SHORT).show()
                        }, modifier = Modifier.fillMaxWidth()
                            .height(40.dp),
                        shape = RoundedCornerShape(70)
                    ) {
                        Text(text = "cadastrar", color = MaterialTheme.colors.primaryVariant)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun SignUpPreview() {
    SignupScreen(navController = NavController(LocalContext.current))
}

/*TODO TOAST CADASTRO CONCLUÍDO*/

