package br.com.digitalhouse.meuboletopago.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class User(
    @SerialName("id") val id: Long,
    @SerialName("name") val name: String,
    @SerialName("email") val email: String,
    @SerialName("password") val password: String? = null,
    @SerialName("recoveryToken") val recoveryToken: String? = null
)
//{
//    "idMovement": 3,
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
//},

@kotlinx.serialization.Serializable
 data class Transaction(
    @SerialName("idMovement") val idMovement: Long,
    @SerialName("valueMovement") val valueMovement: Double? = null,
    @SerialName("dueDate") val dueDate: String? = null,
    @SerialName("descriptionMovement") val descriptionMovement: String? = null ,
    @SerialName("seqParcel")val seqParcel: Int? = null,
    @SerialName("typeMovement") val typeMovement: String? = null ,
    @SerialName("wasPaid") val wasPaid: Boolean? = null,
    @SerialName("user") val user: User
)

@kotlinx.serialization.Serializable
data class TransactionResponse(
    val transactions: List<Transaction>
)
