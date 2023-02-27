package br.com.digitalhouse.meuboletopago.util

import io.ktor.http.*

class SendFailedException(val statusCode: HttpStatusCode,
                          override val message: String? = "Falha no envio da requisição") : Exception()