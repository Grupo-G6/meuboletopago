package br.com.digitalhouse.meuboletopago.repository

import br.com.digitalhouse.meuboletopago.api.Api
import br.com.digitalhouse.meuboletopago.extension.updateState
import br.com.digitalhouse.meuboletopago.util.DataResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class DetailRepository(
    private val api: Api = Api.instance,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    suspend fun getMovementDetail(idMovement: String) = flow {
        val chamada = api.getMovementDetail(idMovement)
        emit(DataResult.Success(chamada))
    }.updateState().flowOn(dispatcher)

    companion object {
        val instance by lazy { DetailRepository() }
    }
}