package br.com.digitalhouse.meuboletopago.model

class Login ( val login:String, val password: String ) {
        var usuario = "usuario@kmm.com"
        var senha = "12345"
//        fun validator() = (login == usuario && password == senha)
        fun validator() = (login == "" && password == "")

        fun changePassword() {
                senha = password
        }
}
