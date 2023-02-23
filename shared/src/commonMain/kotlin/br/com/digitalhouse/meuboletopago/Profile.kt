package br.com.digitalhouse.meuboletopago

@kotlinx.serialization.Serializable
class ProfileToken(val token: String, val email: String)

@kotlinx.serialization.Serializable
class Profile (
    val email: String,

    val password: String){
    val token: String = ""
}

//    constructor(email: String, token: String, password: String) {
//        this.email = email
//        this.token = token
//        this.password = password
//    }
//
//}