package br.com.digitalhouse.meuboletopago.network


import br.com.digitalhouse.meuboletopago.model.Transaction
//import br.com.digitalhouse.meuboletopago.model.TransactionType
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object Network {

    suspend fun login(): Int {
        delay(1000)

        return 0
    }

    suspend fun perfil(): Int {
        delay(1000)

        return 1
    }
//    suspend fun getTransa(): Int {
//        delay(1000)
//
//        return 1
//    }

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
//    fun loadTransaction() {
//        val mockData = MutableList(5) {
//            Transaction(
//               "https://media.licdn.com/dms/image/C4E03AQGzYGYIlmUzbg/profile-displayphoto-shrink_800_800/0/1640531489913?e=2147483647&v=beta&t=qmWLp-OvACiTmOfMIYk-T3bCq1R-KQkB7jXM9UsGvfI",
//               "https://media.licdn.com/dms/image/C4E03AQGzYGYIlmUzbg/profile-displayphoto-shrink_800_800/0/1640531489913?e=2147483647&v=beta&t=qmWLp-OvACiTmOfMIYk-T3bCq1R-KQkB7jXM9UsGvfI",
//                TransactionType.DESPESA,
//                45.0,
//                 true,
//                "2023/02/01"
//
//            )
//        }
//        val data = Json.encodeToString(mockData)
//        println("serializando")
//        println(data)
//
//        println("Deserializando")
//        val deserialize = Json.decodeFromString<List<Transaction>>(data)
//        println(deserialize)
//
//        }


