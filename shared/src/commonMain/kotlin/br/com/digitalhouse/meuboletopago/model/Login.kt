package br.com.digitalhouse.meuboletopago.model

@kotlinx.serialization.Serializable
/*TODO ver se é usado*/
class Login ( val email:String, val password: String ) {
        fun validator() = (email == "usuario@kmm.com" && password== "12345")


}
