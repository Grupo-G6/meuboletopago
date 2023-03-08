package br.com.digitalhouse.meuboletopago.android.passwordrecovery

import AlertDialogComponent
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.android.components.LoadingIndicator
import br.com.digitalhouse.meuboletopago.util.DataResult

@Composable
fun RecoverPassword(navController: NavController){
    val context = LocalContext.current
    val showDialog = remember { mutableStateOf(false) }
    MyApplicationTheme {
        Scaffold(
            topBar =   { TopAppBar(
                backgroundColor = MaterialTheme.colors.primaryVariant,
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
                val email = remember { mutableStateOf(TextFieldValue()) }
                val viewModel : RecPasswordViewModel = viewModel()
                val sendState by viewModel.emailState.collectAsState()
                val context = LocalContext.current
                AlertDialogComponent(
                    showDialog = showDialog.value,
                    message = "E-mail não cadastrado\nTente novamente",
                    onDismissRequest = {
                        showDialog.value = !showDialog.value
                    }
                )
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
                        shape = RoundedCornerShape(20.dp),
                        value = email.value,
                        onValueChange = { email.value = it },
                        label = {
                            Text(text = "E-mail")
                        }
                    )

                    if (sendState is DataResult.Loading){
                        LoadingIndicator()
                    } else {
                        if (sendState is DataResult.Send){
                            Toast.makeText(context,
                                "O token foi enviado, cheque seu e-mail",
                                Toast.LENGTH_SHORT).show()
                            navController.navigate("password_page")
                            viewModel.setDefaultState()
                        }
                        if (sendState is DataResult.Error) {
                            showDialog.value = !showDialog.value
                            email.value = TextFieldValue("")
                            viewModel.setDefaultState()
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = {
                                viewModel.sendRecoverEmail(email = email.value.text)
                           },
                            modifier = Modifier.fillMaxWidth()
                            .height(40.dp),
                              shape = RoundedCornerShape(70),
                            colors = ButtonDefaults.buttonColors(MaterialTheme.colors.primary))

                        {
                            Text(text = "Enviar e-mail",
                                color = MaterialTheme.colors.primaryVariant)
                        }
                    }
                }
            }
        }
    }
}

