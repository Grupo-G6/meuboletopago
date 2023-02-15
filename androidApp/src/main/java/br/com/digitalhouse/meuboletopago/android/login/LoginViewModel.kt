//package br.com.digitalhouse.meuboletopago.android.login
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import br.com.digitalhouse.dhwallet.api.Api
//import br.com.digitalhouse.meuboletopago.model.Login
//import kotlinx.coroutines.launch
//
//class LoginViewModel: ViewModel(/*val repository: LoginRepository*/) {
//
////função que bate diretamente na Api
//    fun login(email: String, password: String) = viewModelScope.launch{
//        Api.token = Api.instance.login(Login("usuario@dhwallet.com.br", "123456"))
//
//    }
//}