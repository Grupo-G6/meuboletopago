package br.com.digitalhouse.meuboletopago.android.passwordrecovery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.digitalhouse.meuboletopago.model.NewPassword
import br.com.digitalhouse.meuboletopago.repository.ChangePasswordRepository
import br.com.digitalhouse.meuboletopago.util.DataResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ChangePasswordViewModel(private val repository: ChangePasswordRepository = ChangePasswordRepository.instance) : ViewModel() {
    private val _changedState : MutableStateFlow<DataResult<Nothing>> = MutableStateFlow(DataResult.Empty)
    val changedState : StateFlow<DataResult<Nothing>> = _changedState

    fun changePassword(token: String, newPassword: String) = viewModelScope.launch {

        repository.changePassword(NewPassword(token, newPassword)).collectLatest {
            _changedState.value = it as DataResult<Nothing>
        }
    }

    fun setDefaultState() {
        _changedState.value = DataResult.Empty
    }
}
