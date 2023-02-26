package br.com.digitalhouse.meuboletopago.android.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.digitalhouse.meuboletopago.model.Transaction
import br.com.digitalhouse.meuboletopago.repository.TransactionRepository
import br.com.digitalhouse.meuboletopago.util.DataResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

//import androidx.lifecycle.SavedStateHandle
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import br.com.digitalhouse.meuboletopago.api.Api
//import br.com.digitalhouse.meuboletopago.model.Login
//import br.com.digitalhouse.meuboletopago.Profile
//import br.com.digitalhouse.meuboletopago.model.Transaction
//import br.com.digitalhouse.meuboletopago.network.TransactionRepository
//import br.com.digitalhouse.meuboletopago.util.DataResult
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.collectLatest
//import kotlinx.coroutines.launch
//
//class HomeViewModel(
//    private val savedStateHandle: SavedStateHandle
//) : ViewModel() {
//    private val repository: TransactionRepository = TransactionRepository()
//    private val search = savedStateHandle.getStateFlow("search_key", "")
//    private val _transactions = MutableStateFlow<DataResult<List<Transaction>>>(DataResult.Empty)
//    val transactions: StateFlow<DataResult<List<Transaction>>> = _transactions
//
//    private val _profile = MutableStateFlow<DataResult<Profile>?>(null)
//    val profile: StateFlow<DataResult<Profile>?> = _profile
//
//
//    private fun search(query: String) {
//        savedStateHandle["search_key"] = query
//    }
//
//    fun login() = viewModelScope.launch {
//        Api.token = Api.instance.login(Login("usuario@dhwallet.com.br", "123456")).toString()/*TODO.token*/
//    }.invokeOnCompletion {
//        getTransactions()
//        getProfile()
//    }
//
//    fun getTransactions() = viewModelScope.launch {
//        repository.getTransactions().collectLatest {
//            _transactions.value /* TODO= it*/
//        }
//    }
//
//    fun getProfile() = viewModelScope.launch(Dispatchers.Default) {
//        repository.getProfile().collectLatest {
//            _profile.value  /* TODO= it*/
//        }
//    }
//}
class HomeViewModel(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {
    private val repository: TransactionRepository = TransactionRepository()
    private val _transactions = MutableStateFlow<DataResult<List<Transaction>>>(DataResult.Empty)
    val transactions: StateFlow<DataResult<List<Transaction>>> = _transactions

    init {
        getTransactions()
    }

    fun getTransactions() = viewModelScope.launch {
        repository.getMovement().collectLatest {
            _transactions.value = it
        }
    }




}
