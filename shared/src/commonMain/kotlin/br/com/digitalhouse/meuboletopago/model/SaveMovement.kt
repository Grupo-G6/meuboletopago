package br.com.digitalhouse.meuboletopago.model

class SaveMovement ( val description  : String, val value: String, val dates: String ) {
        fun save() = (description == "academia" && value == "75,00" && dates == "08/01/2023")

}

