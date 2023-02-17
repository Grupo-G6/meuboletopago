package br.com.digitalhouse.meuboletopago.api

@kotlinx.serialization.Serializable
class TransactionResponse (val results: List<Personagem>)

@kotlinx.serialization.Serializable
 class Personagem(val name: String)

