package br.com.digitalhouse.meuboletopago.model

import kotlinx.serialization.Serializable


//REQUEST
@Serializable
data class Movement(
    val valueMovement: Double,
    val dueDate: String,
    val descriptionMovement: String,
    val typeMovement: String? = null,
    val seqParcel: Int,
    val wasPaid: Boolean = false
)

@Serializable
data class MovementResponse(
    val movements: List<Movement>

)

//RESPONSE
@Serializable
data class MovementIdResponse(
    val id: Int,
    val valueMovement: Double,
    val dueDate: String,
    val descriptionMovement: String,
    val typeMovement: String? = null,
    val seqParcel: Int,
    val wasPaid: Boolean = false
)

