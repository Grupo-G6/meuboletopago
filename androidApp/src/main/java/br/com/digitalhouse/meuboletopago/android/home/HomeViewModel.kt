
package br.com.digitalhouse.meuboletopago.android.home
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.digitalhouse.meuboletopago.ProfileToken
import br.com.digitalhouse.meuboletopago.model.Login
import br.com.digitalhouse.meuboletopago.model.Transaction
import br.com.digitalhouse.meuboletopago.network.Network.login
import br.com.digitalhouse.meuboletopago.repository.TransactionRepository
import br.com.digitalhouse.meuboletopago.util.DataResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeViewModel(
//    private val savedStateHandle: SavedStateHandle,
    private val repository: TransactionRepository = TransactionRepository().instance

) : ViewModel() {

    //    private val search = savedStateHandle.getStateFlow("search_key", "")
    private val _homeState =   MutableStateFlow<DataResult<List<Transaction>>>(DataResult.Empty)
    val homeState : StateFlow<DataResult<List<Transaction>>> = _homeState




//    private val _profile = MutableStateFlow<DataResult<Profile>?>(null)
//    val profile: StateFlow<DataResult<Profile>?> = _profile


//    private fun search(query: String) {
//        savedStateHandle["search_key"] = query
//    }
    init{

        getTransactions()
    }

    fun getTransactions( )  = viewModelScope.launch {
        repository.getTransactions().collectLatest {
            _homeState.value = it
        }
    }

        fun defaultState() {
            _homeState.value = DataResult.Empty
        }
    }




//fun login(email:String, password:String) = viewModelScope.launch {
//
//    val login = Login(email, password )
//
//    repository.login(login).collectLatest{
//
//        _loginState.value = it
//
//    }