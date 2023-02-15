//package br.com.digitalhouse.meuboletopago.repository//package br.com.digitalhouse.meuboletopago.network
//
//
//import br.com.digitalhouse.meuboletopago.api.Api
//import br.com.digitalhouse.meuboletopago.extension.updateState
//import br.com.digitalhouse.meuboletopago.util.DataResult
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
//        val chamada = api.getAll()./*TODOtransactions*/
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
