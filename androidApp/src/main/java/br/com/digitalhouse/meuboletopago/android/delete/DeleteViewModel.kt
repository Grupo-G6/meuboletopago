package br.com.digitalhouse.meuboletopago.android.delete

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.digitalhouse.meuboletopago.model.NewPassword
import br.com.digitalhouse.meuboletopago.repository.DeleteRepository
import br.com.digitalhouse.meuboletopago.util.DataResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DeleteViewModel(
    private val repository: DeleteRepository = DeleteRepository.instance
): ViewModel() {
    private val _changedState : MutableStateFlow<DataResult<Nothing>> = MutableStateFlow(DataResult.Empty)
    val changedState : StateFlow<DataResult<Nothing>> = _changedState

    fun deteleMovement(id: String) = viewModelScope.launch {

        repository.deleteMovement(id).collectLatest {
            _changedState.value = it
        }
    }

    fun setDefaultState() {
        _changedState.value = DataResult.Empty
    }
}