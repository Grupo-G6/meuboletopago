package br.com.digitalhouse.meuboletopago

@kotlinx.serialization.Serializable
class ProfileToken(val token: String, val email: String, val id: Int)

@kotlinx.serialization.Serializable
class Profile (
    val email: String,
    val password: String,
    val id: Int){
    val token: String = ""
}

