package br.com.digitalhouse.meuboletopago.android.components

import br.com.digitalhouse.meuboletopago.util.DataResult


fun <R, T : Any> DataResult<T>.fold(
    onSuccess: (value: T) -> R,
    onFailure: (exception: Throwable) -> R,
    onEmpty: () -> R,
    onLoading: () -> R,
    onSendSuccess: () -> R
): R {
    return when (this) {
        is DataResult.Success -> onSuccess(data)
        is DataResult.Error -> onFailure(error)
        is DataResult.Empty -> onEmpty()
        is DataResult.Loading -> onLoading()
        is DataResult.Send -> onSendSuccess()
    }
}
