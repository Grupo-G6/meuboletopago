package br.com.digitalhouse.meuboletopago.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class NewPassword(
    val token: String,
    @SerialName("password")
    val newPassword: String)
