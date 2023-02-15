package br.com.digitalhouse.meuboletopago.model

import br.com.digitalhouse.meuboletopago.util.DateSerializer
import kotlinx.datetime.LocalDate

@kotlinx.serialization.Serializable
data class Transaction(
    val logo:String,
    val title:String,
    val transactionType: TransactionType,
    val value: Double,
    val status: Boolean,
    @kotlinx.serialization.Serializable(with = DateSerializer::class)
    val date: String
)

enum class TransactionType(val description: String) {
    DESPESA("Despesa"),
    RECEITA("Receita")
}