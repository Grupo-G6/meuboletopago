package br.com.digitalhouse.meuboletopago
/*TODO VER SE É USADO */
@kotlinx.serialization.Serializable
class ProfileToken(val token: String, val user: Profile)

@kotlinx.serialization.Serializable
class Profile(val name: String, val email: String, val photo: String) {

    val token: String = ""
}