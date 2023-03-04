package br.com.digitalhouse.meuboletopago.android.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.digitalhouse.meuboletopago.ProfileToken
import br.com.digitalhouse.meuboletopago.model.Login
import br.com.digitalhouse.meuboletopago.repository.LoginRepository
import br.com.digitalhouse.meuboletopago.util.DataResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class LoginViewModel (
    private val repository: LoginRepository = LoginRepository.instance
): ViewModel() {
    private val _loginState : MutableStateFlow<DataResult<ProfileToken>> = MutableStateFlow(DataResult.Empty)
    val loginState : StateFlow<DataResult<ProfileToken>> = _loginState

    fun login(email:String, password:String) = viewModelScope.launch {
        val login = Login(email, password )
        repository.login(login).collectLatest{
            _loginState.value = it
        }
    }
    fun defaultState (){
        _loginState.value = DataResult.Empty
    }
}