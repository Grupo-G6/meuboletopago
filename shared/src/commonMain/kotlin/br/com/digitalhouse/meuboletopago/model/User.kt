package br.com.digitalhouse.meuboletopago.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Int,
    val name: String,
    val email: String,
    val recoveryToken: String? = null
)
