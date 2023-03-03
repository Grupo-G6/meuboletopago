package br.com.digitalhouse.meuboletopago.model

@kotlinx.serialization.Serializable
class ProfileToken(val token: String, val email: String)

@kotlinx.serialization.Serializable
class Profile (
    val email: String,
    val password: String)
{
    val token: String = ""
}


@kotlinx.serialization.Serializable
///*TODO fazer validação senha */
class Login ( val email:String, val password: String ) {


}
