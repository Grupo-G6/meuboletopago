package br.com.digitalhouse.meuboletopago.extension
import br.com.digitalhouse.meuboletopago.util.DataResult
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch

import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.retryWhen

//Flow que recebe o data result e executa os seguintes itens: 1 tentativa (ex sem internet, tentou menos de 3 vezes , dá um delay e retorna true or false).
fun <T : Any> Flow<DataResult<T>>.updateState() =
    retryWhen { cause, attempt ->
        if (cause is IOException && attempt < 3) {
            delay(5000)
            true
        } else {
            false
        }
    }
        .onStart { emit(DataResult.Loading) }
        .catch { emit(DataResult.Error(it)) }
//        .onCompletion {emit(DataResult.Loading(isLoading = false))}