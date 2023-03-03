package br.com.digitalhouse.meuboletopago.repository

import br.com.digitalhouse.meuboletopago.Profile
import br.com.digitalhouse.meuboletopago.ProfileToken
import br.com.digitalhouse.meuboletopago.api.Api
import br.com.digitalhouse.meuboletopago.extension.updateState
import br.com.digitalhouse.meuboletopago.model.Login
import br.com.digitalhouse.meuboletopago.util.DataResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

// colocar na thread default
class LoginRepository(
    private val api: Api = Api.instance,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default,
) {
    // usar o flow: tratamentos (updateState)
    // se o login der certo-> retorna ProfileToken
    suspend fun login(login: Login) = flow<DataResult<ProfileToken>> {
        val dadosApi = api.login(login)
        Api.token = dadosApi.token
        emit(DataResult.Success(api.login(login)))
    }.updateState().flowOn(dispatcher)

    private fun emit(value: DataResult.Success<Profile>) {
    }

    // data result para pegar os estados, sucesso,, erro etc
    // update state -> erro e loading
    // extension
    companion object {
        val instance by lazy { LoginRepository() }
    }
}
