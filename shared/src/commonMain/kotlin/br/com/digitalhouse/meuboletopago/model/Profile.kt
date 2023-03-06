package br.com.digitalhouse.meuboletopago.model

@kotlinx.serialization.Serializable
//REQUEST
class Login ( val email:String, val password: String ) {

}
//RESPONSE
@kotlinx.serialization.Serializable
class Profile (
    val id: Int,
    val email: String,
    val password: String)
{
    val token: String = ""

}


