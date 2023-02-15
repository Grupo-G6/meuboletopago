//package br.com.digitalhouse.dhwallet.repository
//
//import br.com.digitalhouse.dhwallet.api.Api
//import br.com.digitalhouse.dhwallet.extension.updateState
//import br.com.digitalhouse.dhwallet.util.DataResult
//import kotlinx.coroutines.CoroutineDispatcher
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.flow.flow
//import kotlinx.coroutines.flow.flowOn
//
//class TransactionRepository(
//    private val api: Api = Api.instance,
//    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
//) {
//    suspend fun getTransactions() = flow {
//        val chamada = api.getAll().transactions
//
//        if (chamada.isEmpty()) {
//            emit(DataResult.Empty)
//        } else {
//            emit(DataResult.Success(chamada))
//        }
//    }.updateState().flowOn(dispatcher)
//
//    suspend fun getProfile() = flow {
//        emit(DataResult.Success(api.profile()))
//    }.updateState().flowOn(dispatcher)
//
//    companion object {
//        val instance by lazy { TransactionRepository() }
//    }
//}
