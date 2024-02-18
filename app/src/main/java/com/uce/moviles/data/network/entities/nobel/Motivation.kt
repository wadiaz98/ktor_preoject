package com.uce.moviles.data.network.entities.nobel

import kotlinx.serialization.Serializable

@Serializable
data class Motivation(
    val en: String? = null,
    val no: String? = null,
    val se: String? = null
)