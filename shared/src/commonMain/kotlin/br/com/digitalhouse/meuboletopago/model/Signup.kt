package br.com.digitalhouse.meuboletopago.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
 data class SignUp(

    val name: String,
    val email: String,
    val password: String
    ){

        val id: String? = ""
    val recoveryToken: String? = null

 }



@kotlinx.serialization.Serializable
 data class SignIn(
    val id: Long? ,
    val name: String = "",
    val email: String= "" ,
    val password: String= "",
    val recoveryToken: String? = null
) {
    override fun toString(): String {
        return "SignIn(id=$id, name='$name', email='$email', password='$password', recoveryToken=$recoveryToken)"
    }
}




//@Serializable
//data class Movement(
//    val valueMovement: Double,
//    val dueDate: String,
//    val descriptionMovement: String,
//    val typeMovement: String,
//    val seqParcel: Int,
//    val wasPaid: Boolean
//)
//
//@Serializable
//data class MovementResponse(
//    val movements: List<Movement>
//)
//
//
//@Serializable
//data class User(
//    val id: Long,
//    val name: String,
//    val email: String,
//    val password: String,
//    val recoveryToken: String? = null
//)
