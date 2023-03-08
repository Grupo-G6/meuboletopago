package br.com.digitalhouse.meuboletopago.api

import br.com.digitalhouse.meuboletopago.ProfileToken
import br.com.digitalhouse.meuboletopago.model.Email
import br.com.digitalhouse.meuboletopago.model.NewPassword

import br.com.digitalhouse.meuboletopago.model.*

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import br.com.digitalhouse.meuboletopago.model.*
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.util.logging.*
import io.ktor.util.logging.Logger
import kotlinx.serialization.json.Json
import kotlin.native.concurrent.ThreadLocal

class Api {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
                 json(
                Json {
                    // se tiver mais dados, nao precisa validar
                    ignoreUnknownKeys = true
                    useAlternativeNames = false
                    coerceInputValues = true
                },
            )
        }

//        install(Logging) {
//            logger = Logger.DEFAULT
//            level = LogLevel.ALL
//        }
        defaultRequest {
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
            header("Authorization" , token)
        }
    }


    suspend fun assign (signup: SignUp) : SignIn{
          return httpClient.post("$DEFAULT_URL/user/signup") {
            setBody(signup)
        }.body()
    }

    suspend fun login(login: Login): ProfileToken {
        return httpClient.post("$DEFAULT_URL/user/login") {
            setBody(login)
        }.body()
    }

    suspend fun getUser(): User {
        return httpClient.get("$DEFAULT_URL/user/3").body()
    }

    suspend fun getAll(): TransactionResponse {
        val transaction: TransactionSpecification = TransactionSpecification()
        return httpClient.get("$DEFAULT_URL/movement/filter") {
            setBody { transaction }
        }.body()
    }

    suspend fun getMovement(): List<Movement> {
        return httpClient.get("$DEFAULT_URL/movement").body()
    }

    suspend fun getMovementDetail(id: String): Movement {
        return httpClient.get("${DEFAULT_URL}/movement/$id").body()
    }

    suspend fun deleteMovement(id: String): HttpStatusCode {
        return httpClient.delete("$DEFAULT_URL/movement/$id").status
    }

    suspend fun editMovement(id: String, movement: Movement): Movement {
        return httpClient.put("$DEFAULT_URL/movement/$id") {
            setBody(movement)
        }.body()

    }

    suspend fun sendRecoverEmail(email: Email): HttpStatusCode {
        return httpClient.post("$DEFAULT_URL/user/forgot-password") {
            setBody(email)
        }.status
    }

    suspend fun changePassword(newPassword: NewPassword): HttpStatusCode{
        return httpClient.post("$DEFAULT_URL/user/password-recovery"){
            setBody(newPassword)
        }.status
    }

    //inicia no momento da instancia da classe
    //by(delegate)
    //lazy: só executa quando a variável é chamada
    //instance: só sao instanciados se chamada a API

    suspend fun postMovement(movement: Movement): Movement {
        return httpClient.post("$DEFAULT_URL/movement") {
            setBody(movement)
        }.body()
    }


    @ThreadLocal
    companion object {
        val instance by lazy { Api() }
        var token = ""
        const val DEFAULT_URL = "https://meu-boleto-pago-api-production.up.railway.app"
//        const val DEFAULT_URL = "https://meuboletopago-api-production.up.railway.app"
    }

}
