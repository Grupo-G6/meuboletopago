package br.com.digitalhouse.meuboletopago.android.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.digitalhouse.meuboletopago.model.Movement
import br.com.digitalhouse.meuboletopago.repository.DetailRepository
import br.com.digitalhouse.meuboletopago.repository.EditRepository
import br.com.digitalhouse.meuboletopago.util.DataResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class EditViewModel(
    private val repository: EditRepository = EditRepository.instance,
    private val repository2: DetailRepository = DetailRepository.instance
): ViewModel() {
    private val _changedState : MutableStateFlow<DataResult<Movement>> = MutableStateFlow(DataResult.Empty)
    val changedState : StateFlow<DataResult<Movement>> = _changedState

    private val _movement : MutableStateFlow<DataResult<Movement>> = MutableStateFlow<DataResult<Movement>>(DataResult.Empty)
    val movement : StateFlow<DataResult<Movement>> = _movement

    fun getMovementDetails(id: String) = viewModelScope.launch {
        repository2.getMovementDetail(id).collect {
            _movement.value = it
        }
    }

    fun editMovement( idMovement: Movement) = viewModelScope.launch {

        repository.editMovement( idMovement).collectLatest {
            _changedState.value = it
        }
    }

    fun setDefaultState() {
        _changedState.value = DataResult.Empty
    }
}

