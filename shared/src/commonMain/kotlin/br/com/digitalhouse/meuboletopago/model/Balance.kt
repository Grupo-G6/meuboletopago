package br.com.digitalhouse.meuboletopago.model

@kotlinx.serialization.Serializable
data class Balance(
    var debt: Double? = 0.0,
    var credit: Double? = 0.0,
    var balance: Double? = 0.0
)

