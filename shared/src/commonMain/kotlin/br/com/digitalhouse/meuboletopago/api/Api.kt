//package br.com.digitalhouse.dhwallet.api
//
////import br.com.digitalhouse.dhwallet.model.Login
////import br.com.digitalhouse.dhwallet.model.Profile
////import br.com.digitalhouse.dhwallet.model.ProfileToken
////import br.com.digitalhouse.dhwallet.model.TransactionResponse
//import io.ktor.client.HttpClient
//import io.ktor.client.call.body
//import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
//import io.ktor.client.plugins.defaultRequest
//import io.ktor.client.request.accept
//import io.ktor.client.request.get
//import io.ktor.client.request.header
//import io.ktor.client.request.post
//import io.ktor.client.request.setBody
//import io.ktor.http.ContentType
//import io.ktor.http.contentType
//import io.ktor.serialization.kotlinx.json.json
//import kotlinx.serialization.json.Json
//import kotlin.native.concurrent.ThreadLocal
//
//class Api {
//    private val httpClient = HttpClient {
//        install(ContentNegotiation) {
//            json(
//                Json {
//                    ignoreUnknownKeys = true
//                    useAlternativeNames = false
//                },
//            )
//        }
//
//        defaultRequest {
//            contentType(ContentType.Application.Json)
//            accept(ContentType.Application.Json)
//            header("Authorization", "Bearer $token")
//        }
//    }
//
//    suspend fun getAll(): TransactionResponse {
//        return httpClient.get("$DEFAULT_URL/transaction").body()
//    }
//
//    suspend fun login(login: Login): ProfileToken {
//        return httpClient.post("$DEFAULT_URL/login") {
//            setBody(login)
//        }.body()
//    }
//
//    suspend fun profile(): Profile = httpClient.get("$DEFAULT_URL/user/profile").body()
//
//    @ThreadLocal
//    companion object {
//        val instance by lazy { Api() }
//        var token = ""
//        const val DEFAULT_URL = "https://dh-wallet-2.herokuapp.com"
//    }
//}
