package br.com.digitalhouse.meuboletopago.network


import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.datetime.Clock


object Network {

    suspend fun login(): Int {
        delay(1000)

        return 0
    }

    suspend fun perfil(): Int {
        delay(1000)

        return 1
    }

    fun carregarDados(): String {
        var dados = ""

        runBlocking {
            val start = Clock.System.now().toEpochMilliseconds()
            val loginAsync = async { login() }
            val perfilAsync = async { perfil() }

            println(loginAsync.await())
            println(perfilAsync.await())

            dados = "Tempo: ${(Clock.System.now().toEpochMilliseconds() - start) / 1000} segundos"
        }

        return dados
    }
}
