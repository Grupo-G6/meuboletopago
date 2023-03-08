package br.com.digitalhouse.meuboletopago.android.home

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.digitalhouse.meuboletopago.model.Balance
import br.com.digitalhouse.meuboletopago.model.Movement
import br.com.digitalhouse.meuboletopago.model.User
import br.com.digitalhouse.meuboletopago.repository.BalanceRepository
import br.com.digitalhouse.meuboletopago.repository.TransactionRepository
import br.com.digitalhouse.meuboletopago.repository.UserRepository
import br.com.digitalhouse.meuboletopago.util.DataResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel (

    application: Application,  private val savedStateHandle: SavedStateHandle
) : AndroidViewModel(application) {
    private val transactionRepository: TransactionRepository = TransactionRepository.instance
    private val userRepository: UserRepository = UserRepository.instance
    private val balanceRepository: BalanceRepository = BalanceRepository.instance

    private val _transactions = MutableStateFlow<DataResult<List<Movement>>>(DataResult.Empty)
    val transactions: StateFlow<DataResult<List<Movement>>> = _transactions

    private val _user = MutableStateFlow<DataResult<User>>(DataResult.Empty)
    val user: StateFlow<DataResult<User>> = _user

    private val _balance = MutableStateFlow<DataResult<Balance>>(DataResult.Empty)
    val balance: StateFlow<DataResult<Balance>> = _balance

//    init {
//        getAll()
//        getUser()
//
//    }

    fun getAll() = viewModelScope.launch {
        transactionRepository.getAll().collect {
            _transactions.value = it
        }
    }

    fun getUser(id: String) = viewModelScope.launch {
        userRepository.getUser(id).collect {
            _user.value = it
        }
    }
    fun getBalance() = viewModelScope.launch {
        balanceRepository.getBalance().collect {
            _balance.value = it
        }
    }
}

