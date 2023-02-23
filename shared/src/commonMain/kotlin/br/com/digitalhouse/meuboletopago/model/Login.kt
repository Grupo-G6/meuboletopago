package br.com.digitalhouse.meuboletopago.model

@kotlinx.serialization.Serializable
/*TODO fazer validação senha */
class Login ( val email:String, val password: String ) {
        fun validator() = (email == "usuario@kmm.com" && password== "12345")


}
