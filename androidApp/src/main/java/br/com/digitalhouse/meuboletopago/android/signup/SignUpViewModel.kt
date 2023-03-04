package br.com.digitalhouse.meuboletopago.android.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import br.com.digitalhouse.meuboletopago.model.SignIn
import br.com.digitalhouse.meuboletopago.model.SignUp

import br.com.digitalhouse.meuboletopago.repository.SignUpRepository
import br.com.digitalhouse.meuboletopago.util.DataResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SignUpViewModel (
    private val repository: SignUpRepository = SignUpRepository.instance
    )
    : ViewModel() {


    private val _signUpState : MutableStateFlow<DataResult<SignIn>> = MutableStateFlow(DataResult.Empty)

    val signUpState : StateFlow<DataResult<SignIn>> = _signUpState


    fun assign(signup: SignUp) = viewModelScope.launch {
        repository.assign(signup).collectLatest {
            _signUpState.value = it
        }
    }
    fun defaultState (){
        _signUpState.value = DataResult.Empty
    }


}
