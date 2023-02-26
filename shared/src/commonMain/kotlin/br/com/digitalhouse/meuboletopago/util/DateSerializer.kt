package br.com.digitalhouse.meuboletopago.util

import kotlinx.datetime.LocalDate
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/*SERIALIZANDO DATA PARA STRING (ou outro atributo)*/
object DateSerializer : KSerializer<String> {
        override val descriptor =
            PrimitiveSerialDescriptor("Date", PrimitiveKind.STRING)
        override fun serialize(encoder: Encoder, value: String) =
            encoder.encodeString(value.toString())
        override fun deserialize(decoder: Decoder) =
          decoder.decodeString()
}
