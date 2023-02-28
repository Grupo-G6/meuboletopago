package br.com.digitalhouse.meuboletopago.model


import kotlinx.serialization.SerialName


//
//{
//    "idMovement": 4,
//    "valueMovement": 105.0,
//    "dueDate": "2000-11-16",
//    "descriptionMovement": "teste",
//    "seqParcel": 1,
//    "typeMovement": "1",
//    "wasPaid": false,
//    "user": {
//    "id": 3,
//    "name": "Leticia",
//    "email": "letcarvalhomarques@gmail.com",
//    "password": "$2a$10$uNiuzxLlk12sSbLG4LGzru6eGANqxaAbg3KblaJwFNB2SsAoAJzZ2",
//    "recoveryToken": null
//}
//}
//}
@kotlinx.serialization.Serializable
 class Transaction(
    @SerialName("idMovement") val id: Int?,
    @SerialName("valueMovement") val value: Double?,
    @SerialName("dueDate") val dueDate: String?,
    @SerialName("descriptionMovement") val description: String?,
    @SerialName("seqParcel") val seqParcel: Int?,
    @SerialName("typeMovement") val type: String?,
    @SerialName("wasPaid") val wasPaid: Boolean?,
    @SerialName("user") val user: User?
){
//       "idMovement": 4,
////    "valueMovement": 105.0,
////    "dueDate": "2000-11-16",
////    "descriptionMovement": "teste",
////    "seqParcel": 1,
////    "typeMovement": "1",
////    "wasPaid": false,
////    "user": {
////    "id": 3,
////    "name": "Leticia",
////    "email": "letcarvalhomarques@gmail.com",
////    "password": "$2a$10$uNiuzxLlk12sSbLG4LGzru6eGANqxaAbg3KblaJwFNB2SsAoAJzZ2",
//    "recoveryToken": null
 }


@kotlinx.serialization.Serializable
class User(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("email") val email: String,
    @SerialName("password") val password: String?,
    @SerialName("recoveryToken") val recoveryToken: String?
)


//    var idMovement: Long? = null,
//
//    var valueMovement: Double = 0.0,
//
//    var dueDate: LocalDate? = null,
//
//    var descriptionMovement: String? = null,
//
//    var seqParcel: Int = 0,
//
//    var typeMovement: String? = null,
//
//    var wasPaid: Boolean? = null,

//    var user: Users? = null
//    val id: Int,
//    val valueMovement: Double,
//    val dueDate:  Date,
//    val descriptionMovement: String,
//    val seqParcel: Int,
//    val typeMovement: TypeMovement,
//    val wasPaid": Boolean
//)

@kotlinx.serialization.Serializable
data class TransactionResponse(
    val transactions: List<Transaction>
)

//enum class TransactionType(val description: String) {
//    CREDIT("Crédito"),
//    DEBIT("Pagamento")
//}