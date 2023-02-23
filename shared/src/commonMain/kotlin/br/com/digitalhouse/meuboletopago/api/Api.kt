package br.com.digitalhouse.meuboletopago.api

//import br.com.digitalhouse.dhwallet.model.Login
//import br.com.digitalhouse.dhwallet.model.Profile
//import br.com.digitalhouse.dhwallet.model.ProfileToken
//import br.com.digitalhouse.dhwallet.model.TransactionResponse
import br.com.digitalhouse.meuboletopago.model.Login
import br.com.digitalhouse.meuboletopago.Profile
import br.com.digitalhouse.meuboletopago.ProfileToken

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.json
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

    suspend fun getAll(): TransactionResponse {
        return httpClient.get("https://rickandmortyapi.com/api/character")
            .body()
    }

    suspend fun login(login: Login): ProfileToken {
        return httpClient.post("https://meu-boleto-pago-api-production.up.railway.app/user/login") {
            setBody(login)
        }.body()
    }


//    suspend fun profile(): Profile = httpClient.get("https://dh-food-api.herokuapp.com/user/profile").body()

    //inicia no momento da instancia da classe
    //by(delegate)
    //lazy: só executa quando a variável é chamada
    //instance: só sao instanciados se chamada a API
    @ThreadLocal
    companion object {
        val instance by lazy { Api() }
        var token = ""
        const val DEFAULT_URL = "https://meu-boleto-pago-api-production.up.railway.app/"

    }
}
