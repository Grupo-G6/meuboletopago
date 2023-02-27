package br.com.digitalhouse.meuboletopago.repository

import br.com.digitalhouse.meuboletopago.api.Api
import br.com.digitalhouse.meuboletopago.extension.updateState
import br.com.digitalhouse.meuboletopago.model.NewPassword
import br.com.digitalhouse.meuboletopago.util.DataResult
import br.com.digitalhouse.meuboletopago.util.SendFailedException
import io.ktor.http.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ChangePasswordRepository(
    private val api: Api = Api.instance,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    suspend fun changePassword(newPassword: NewPassword) = flow<DataResult<Any>> {
        val response: HttpStatusCode = api.changePassword(newPassword)
        if (response == HttpStatusCode.OK){
            emit(DataResult.Send)
        } else {
            emit(DataResult.Error(SendFailedException(response)))
        }
    }.updateState().flowOn(dispatcher)

    companion object {
        val instance by lazy { ChangePasswordRepository() }
    }
}