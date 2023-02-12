package br.com.digitalhouse.meuboletopago.model

class Login ( val login:String, val senha: String ) {
        fun validator() = (login == "usuario@kmm.com" && senha == "12345")
//        fun validator() = (login == "" && senha == "")

}
