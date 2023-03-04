package br.com.digitalhouse.meuboletopago.api


import br.com.digitalhouse.meuboletopago.model.*

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
                    coerceInputValues = true
                }
            )
        }
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

/*TODO DIRECIONAR PARA PÁGINA DE PROFILE OU HOME */




    @ThreadLocal
    companion object {
        val instance by lazy { Api() }
        var token = ""
        const val DEFAULT_URL = "https://meuboletopago-api-production.up.railway.app"

    }
}

