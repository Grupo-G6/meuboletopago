package br.com.digitalhouse.meuboletopago.model

class Login ( val loginEnter:String, val senha: String ) {
        fun validator() = (loginEnter == "usuario@kmm.com" && senha == "12345")
//        fun validator() = (login == "" && senha == "")

}
