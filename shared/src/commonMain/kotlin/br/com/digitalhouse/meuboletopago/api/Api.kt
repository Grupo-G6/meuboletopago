package br.com.digitalhouse.meuboletopago.api

//import br.com.digitalhouse.dhwallet.model.Login
//import br.com.digitalhouse.dhwallet.model.Profile
//import br.com.digitalhouse.dhwallet.model.ProfileToken
//import br.com.digitalhouse.dhwallet.model.TransactionResponse

import br.com.digitalhouse.meuboletopago.ProfileToken
import br.com.digitalhouse.meuboletopago.model.Login
import br.com.digitalhouse.meuboletopago.model.Transaction
import br.com.digitalhouse.meuboletopago.model.TransactionResponse
import br.com.digitalhouse.meuboletopago.model.TransactionSpecification
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import kotlin.native.concurrent.ThreadLocal

class Api {
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            //como vai arenderizar o conteúdo
            json(
                Json {
                    //se tiver mais dados, nao precisa validar
                    ignoreUnknownKeys = true
                    useAlternativeNames = false
                }
            )
        }
        defaultRequest {
            contentType(ContentType.Application.Json)
            accept(ContentType.Application.Json)
            header("Authorization" , token)
        }
    }


    suspend fun login(login: Login): ProfileToken {
        return httpClient.post("$DEFAULT_URL/user/login") {
            setBody(login)
        }.body()
    }

    suspend fun getAll(): TransactionResponse {
        val transaction: TransactionSpecification = TransactionSpecification()
        return httpClient.get("$DEFAULT_URL/movement/filter"){
            setBody { transaction
            }
        }.body()
    }

/*TODO DIRECIONAR PARA PÁGINA DE PROFILE OU HOME */
//    suspend fun profile(): Profile = httpClient.get("https://dh-food-api.herokuapp.com/user/profile").body()


    @ThreadLocal
    companion object {
        val instance by lazy { Api() }
        var token = "Basic aGVyaWNrc2ltb25AZ21haWwuY29tOjEyMzQ1Ng=="
        const val DEFAULT_URL = "https://meuboletopago-api-production.up.railway.app"

    }
}
