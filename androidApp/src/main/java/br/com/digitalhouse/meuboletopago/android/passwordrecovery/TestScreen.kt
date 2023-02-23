package br.com.digitalhouse.meuboletopago.android.passwordrecovery

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.digitalhouse.meuboletopago.android.MyApplicationTheme
import br.com.digitalhouse.meuboletopago.util.DataResult

@Composable
fun TestScreen(){
    MyApplicationTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            val email = remember { mutableStateOf(TextFieldValue()) }
            val viewModel : RecPasswordViewModel = viewModel()
            val sendState by viewModel.emailState.collectAsState()
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = "E-mail")
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = email.value,
                    onValueChange = { email.value = it },
                    label = { Text(text = "E-mail") }
                )
                if (sendState is DataResult.Loading){
                    CircularProgressIndicator()
                } else {
                    if (sendState is DataResult.Send){
                        Text(text= "deu certo")
                    }
                    if (sendState is DataResult.Error) {
                        Text(text = "deu erro")
                    }
                    Button(
                        onClick = {
                            viewModel.sendRecoverEmail(
                                email = email.value.text
                            )
                        }, modifier = Modifier.fillMaxWidth()
                    )
                    {
                        Text(text = "Enviar")
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun TestScreen_Preview(){
    TestScreen()
}