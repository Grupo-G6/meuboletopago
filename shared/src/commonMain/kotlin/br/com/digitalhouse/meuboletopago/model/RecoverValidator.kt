package br.com.digitalhouse.meuboletopago.model

class RecoverValidator (
    val password:String, val passwordConfirm: String )
{
    fun recover() = (password == passwordConfirm)
}


