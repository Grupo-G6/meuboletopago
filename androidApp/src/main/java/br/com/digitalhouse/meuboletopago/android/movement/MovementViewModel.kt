package br.com.digitalhouse.meuboletopago.android.movement

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.digitalhouse.meuboletopago.model.Movement
import br.com.digitalhouse.meuboletopago.repository.MovementRepository
import br.com.digitalhouse.meuboletopago.util.DataResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MovementViewModel (
    val repository: MovementRepository = MovementRepository.instance
): ViewModel() {
    private val _movement: MutableStateFlow<DataResult<Movement>> = MutableStateFlow(DataResult.Empty)
    val movement : StateFlow<DataResult<Movement>> = _movement

    fun postMovement(movement: Movement) = viewModelScope.launch {
        repository.postMovement(movement).collectLatest {
            _movement.value = it
        }
    }
    fun defaultState (){
        _movement.value = DataResult.Empty
    }
}