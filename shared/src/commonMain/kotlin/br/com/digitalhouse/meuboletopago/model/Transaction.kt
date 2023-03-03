package br.com.digitalhouse.meuboletopago.model

import br.com.digitalhouse.meuboletopago.util.DateSerializer
import kotlinx.datetime.LocalDate

@kotlinx.serialization.Serializable
data class ListTransaction(
    val valueMovement: Double,
    val descriptionMovement: String,
    val typeMovement: String,
    val seqParcel: Int,
    val wasPaid: Boolean,
    @kotlinx.serialization.Serializable(with = DateSerializer::class)
    val dueDate: String,
)

data class Transaction(
    val transaction: List<ListTransaction>
)

//enum class TransactionType(val description: String) {
//    DESPESA("Despesa"),
//    RECEITA("Receita")
//}