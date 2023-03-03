package br.com.digitalhouse.meuboletopago.repository


import br.com.digitalhouse.meuboletopago.ProfileToken
import br.com.digitalhouse.meuboletopago.api.Api
import br.com.digitalhouse.meuboletopago.extension.updateState
import br.com.digitalhouse.meuboletopago.model.Login
import br.com.digitalhouse.meuboletopago.util.DataResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


class LoginRepository(
    private val api: Api = Api.instance,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default,
) {
    suspend fun login(login: Login) = flow<DataResult<ProfileToken>> {
        val dadosApi = api.login(login)
        Api.token = dadosApi.token
        emit(DataResult.Success(api.login(login)))
    }.updateState().flowOn(dispatcher)

      companion object {
        val instance by lazy { LoginRepository() }
    }
}
