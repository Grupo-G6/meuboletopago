//import androidx.lifecycle.SavedStateHandle
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import br.com.digitalhouse.dhwallet.api.Api
//import br.com.digitalhouse.meuboletopago.model.Login
////import br.com.digitalhouse.dhwallet.api.Api
////import br.com.digitalhouse.dhwallet.model.Login
////import br.com.digitalhouse.dhwallet.model.Profile
////import br.com.digitalhouse.dhwallet.model.Transaction
////import br.com.digitalhouse.dhwallet.repository.TransactionRepository
////import br.com.digitalhouse.dhwallet.util.DataResult
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.collectLatest
//import kotlinx.coroutines.launch
//
//class HomeViewModel(
//    private val savedStateHandle: SavedStateHandle
//) : ViewModel() {
////    private val repository: TransactionRepository = TransactionRepository()
////    private val search = savedStateHandle.getStateFlow("search_key", "")
////    private val _transactions = MutableStateFlow<DataResult<List<Transaction>>>(DataResult.Empty)
////    val transactions: StateFlow<DataResult<List<Transaction>>> = _transactions
////
////    private val _profile = MutableStateFlow<DataResult<Profile>?>(null)
////    val profile: StateFlow<DataResult<Profile>?> = _profile
//
//
//    private fun search(query: String) {
//        savedStateHandle["search_key"] = query
//    }
//
//    fun login() = viewModelScope.launch {
//        Api.token = Api.instance.login(Login("usuario@dhwallet.com.br", "123456")).token
//    }.invokeOnCompletion {
//        getTransactions()
//        getProfile()
//    }
//
//    fun getTransactions() = viewModelScope.launch {
//        repository.getTransactions().collectLatest {
//            _transactions.value = it
//        }
//    }
//
//    fun getProfile() = viewModelScope.launch(Dispatchers.Default) {
//        repository.getProfile().collectLatest {
//            _profile.value = it
//        }
//    }
//}
