package br.com.digitalhouse.meuboletopago.repository

import br.com.digitalhouse.meuboletopago.api.Api
import br.com.digitalhouse.meuboletopago.extension.updateState
import br.com.digitalhouse.meuboletopago.model.Login
import br.com.digitalhouse.meuboletopago.model.ProfileToken
import br.com.digitalhouse.meuboletopago.model.SignIn
import br.com.digitalhouse.meuboletopago.model.SignUp
import br.com.digitalhouse.meuboletopago.util.DataResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class SignUpRepository(
    private  val api: Api = Api.instance,
 private  val dispatcher: CoroutineDispatcher = Dispatchers.Default)

{

    suspend fun assign (signup: SignUp) =
        flow<DataResult<SignIn>>{
            val chamada = api.assign(signup)
        emit(DataResult.Success(chamada))
    }.updateState().flowOn(dispatcher)


    private fun emit(value: DataResult.Success<SignIn>) {

    }


    //data result para pegar os estados, sucesso,, erro etc
    //update state -> erro e loading
    //extension
    companion object {
        val instance by lazy {SignUpRepository()}
    }
}