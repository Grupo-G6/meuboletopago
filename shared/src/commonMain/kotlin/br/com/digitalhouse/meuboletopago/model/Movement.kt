package br.com.digitalhouse.meuboletopago.model

import kotlinx.serialization.Serializable

@Serializable
data class Movement(
    val valueMovement: Double,
    val dueDate: String,
    val descriptionMovement: String,
    val typeMovement: String,
    val seqParcel: Int,
    val wasPaid: Boolean
)

@Serializable
data class MovementResponse(
    val movements: List<Movement>
)