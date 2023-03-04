package br.com.digitalhouse.meuboletopago.model

@kotlinx.serialization.Serializable
 data class SignUp(
//    val id: Long?,
    val name: String,
    val email: String,
    val password: String,
//    val recoveryToken: String? = null
    ) {

  }


@kotlinx.serialization.Serializable
 data class SignIn(
    val id: Int,
    val name: String,
    val email: String,
    val password: String,
    val recoveryToken: String? = null
)


