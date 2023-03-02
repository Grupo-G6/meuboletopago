package br.com.digitalhouse.meuboletopago.android.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.digitalhouse.meuboletopago.model.Movement
import br.com.digitalhouse.meuboletopago.model.Transaction
import br.com.digitalhouse.meuboletopago.model.TransactionResponse
import br.com.digitalhouse.meuboletopago.model.User
import br.com.digitalhouse.meuboletopago.repository.TransactionRepository
import br.com.digitalhouse.meuboletopago.repository.UserRepository
import br.com.digitalhouse.meuboletopago.util.DataResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {
    private val repository: TransactionRepository = TransactionRepository()
    private val repository2: UserRepository = UserRepository()
//    private val _transactions = MutableStateFlow<DataResult<List<Transaction>>>(DataResult.Empty)
//    val transactions: StateFlow<DataResult<List<Transaction>>> = _transactions
    private val _transactions = MutableStateFlow<DataResult<List<Movement>>>(DataResult.Empty)
    val transactions: StateFlow<DataResult<List<Movement>>> = _transactions
    private val _user = MutableStateFlow<DataResult<User>>(DataResult.Empty)
    val user: StateFlow<DataResult<User>> = _user

    init {
        getAll()
        getUser()
    }

    fun getAll() = viewModelScope.launch {
        repository.getAll().collect {
            _transactions.value = it
        }
    }

    fun getUser() = viewModelScope.launch {
        repository2.getUser().collectLatest {
            _user.value = it
        }
    }



}
