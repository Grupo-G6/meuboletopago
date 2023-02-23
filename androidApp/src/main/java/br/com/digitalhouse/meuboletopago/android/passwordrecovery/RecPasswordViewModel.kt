package br.com.digitalhouse.meuboletopago.android.passwordrecovery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.digitalhouse.meuboletopago.repository.PasswordRecRepository
import br.com.digitalhouse.meuboletopago.model.Email
import br.com.digitalhouse.meuboletopago.util.DataResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class RecPasswordViewModel(private val repository : PasswordRecRepository = PasswordRecRepository.instance): ViewModel() {
    private val  _emailState : MutableStateFlow<DataResult<Nothing>> = MutableStateFlow(DataResult.Empty)
    val emailState : StateFlow<DataResult<Nothing>> = _emailState

    fun sendRecoverEmail(email: String) = viewModelScope.launch {
        val emailObj = Email(email)
        repository.sendRecoverEmail(emailObj).collectLatest {
            _emailState.value = it
        }
    }
}