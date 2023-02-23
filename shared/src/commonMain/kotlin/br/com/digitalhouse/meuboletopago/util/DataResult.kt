package br.com.digitalhouse.meuboletopago.util

sealed class DataResult<out T : Any> {
    data class Success<out T : Any>(val data: T) : DataResult<T>()
    data class Error(val error: Throwable) : DataResult<Nothing>()
    object Send : DataResult<Nothing>()
    object Loading : DataResult<Nothing>()
    object Empty : DataResult<Nothing>()
}