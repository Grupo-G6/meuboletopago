package br.com.digitalhouse.meuboletopago.model
/*TODO EXCLUIR CLASSE*/
@kotlinx.serialization.Serializable
data class Transaction(
    val idMovement: Long,
    val valueMovement: Double,
    val dueDate: String,
    val descriptionMovement: String,
    val seqParcel: Int,
    val typeMovement: String,
    val wasPaid: Boolean,
    val user: User
)

@kotlinx.serialization.Serializable
data class TransactionResponse(
    val transactions: List<Transaction>
)

@kotlinx.serialization.Serializable
data class TransactionSpecification(
    val dueDateIni: String? = "15/11/2000",
    val dueDateEnd: String? = "17/11/2000",
    val typeMovement: String? = "1",
    val descriptionMovement: String? = "teste",
    val idUser: Long? = 1,
    val valueMovementIni: Double? = 44.0,
    val valueMovementEnd: Double? = 46.0,
    val wasPaid: Boolean? = false,
    val idMovement: Long? = null
//    val seqParcel: Int? = null
)

@kotlinx.serialization.Serializable
data class TransactionSpec(
    val transactionsSpec: List<TransactionSpecification>
)
