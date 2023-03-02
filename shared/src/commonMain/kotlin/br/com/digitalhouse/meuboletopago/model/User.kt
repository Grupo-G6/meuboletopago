package br.com.digitalhouse.meuboletopago.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Long,
    val name: String,
    val email: String,
    val password: String,
    val recoveryToken: String? = null
)