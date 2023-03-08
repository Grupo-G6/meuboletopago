package br.com.digitalhouse.meuboletopago.repository

import br.com.digitalhouse.meuboletopago.api.Api
import br.com.digitalhouse.meuboletopago.extension.updateState
import br.com.digitalhouse.meuboletopago.model.Movement
import br.com.digitalhouse.meuboletopago.util.DataResult
import br.com.digitalhouse.meuboletopago.util.SendFailedException
import io.ktor.http.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class EditRepository (
    private val api: Api = Api.instance,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    suspend fun editMovement(idMovement: Movement) = flow {
        val chamada = api.editMovement(idMovement)
        emit(DataResult.Success(chamada))
    }.updateState().flowOn(dispatcher)

    companion object {
        val instance by lazy { EditRepository() }
    }
}

