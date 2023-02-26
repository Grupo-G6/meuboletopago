package br.com.digitalhouse.meuboletopago.model

@kotlinx.serialization.Serializable
data class Transaction(
    val idMovement: Long,
    val valueMovement: Double,
//    @kotlinx.serialization.Serializable(with = DateSerializer::class)
    val dueDate: String,
    val descriptionMovement: String,
//    val seqParcel: Int,
    val typeMovement: String,
    val wasPaid: Boolean
)

@kotlinx.serialization.Serializable
data class TransactionSpecification(
    val idMovement: Long? = 1,
    val valueMovementIni: Double = 44.0,
    val valueMovementEnd: Double = 46.0,
//    @kotlinx.serialization.Serializable(with = DateSerializer::class)
    val dueDateIni: String = "2000-11-15",
    val dueDateEnd: String = "2000-11-17",
    val descriptionMovement: String = "",
//    val seqParcel: Int? = null,
    val typeMovement: String = "",
    val wasPaid: Boolean = false,
    val idUser: Long = 1
)


@kotlinx.serialization.Serializable
data class TransactionResponse(
    val transactions: List<Transaction>
)
//enum class TransactionType(val description: String) {
//    DESPESA("Despesa"),
//    RECEITA("Receita")
//}