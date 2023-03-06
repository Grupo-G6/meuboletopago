package br.com.digitalhouse.meuboletopago.android.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.digitalhouse.meuboletopago.model.Movement
import br.com.digitalhouse.meuboletopago.repository.DetailRepository
import br.com.digitalhouse.meuboletopago.util.DataResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repository: DetailRepository = DetailRepository.instance
): ViewModel() {
    private val _movement : MutableStateFlow<DataResult<Movement>> = MutableStateFlow<DataResult<Movement>>(DataResult.Empty)
    val movement : StateFlow<DataResult<Movement>> = _movement

    fun getMovementDetails(id: String) = viewModelScope.launch {
        repository.getMovementDetail(id).collect {
            _movement.value = it
        }
    }
}