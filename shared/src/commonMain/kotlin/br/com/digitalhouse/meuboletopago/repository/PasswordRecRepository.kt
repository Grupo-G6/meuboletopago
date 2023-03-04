package br.com.digitalhouse.meuboletopago.repository

import br.com.digitalhouse.meuboletopago.api.Api
import br.com.digitalhouse.meuboletopago.extension.updateState
import br.com.digitalhouse.meuboletopago.model.Email
import br.com.digitalhouse.meuboletopago.util.DataResult
import br.com.digitalhouse.meuboletopago.util.SendFailedException
import io.ktor.http.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PasswordRecRepository(
    private val api: Api = Api.instance,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    suspend fun sendRecoverEmail(email: Email) = flow<DataResult<Any>> {
        val response: HttpStatusCode = api.sendRecoverEmail(email)
        if (response == HttpStatusCode.OK){
            emit(DataResult.Send)
        } else {
            emit(DataResult.Error(SendFailedException(response)))
        }
    }.updateState().flowOn(dispatcher)



    companion object {
        val instance by lazy {PasswordRecRepository()}
    }
}