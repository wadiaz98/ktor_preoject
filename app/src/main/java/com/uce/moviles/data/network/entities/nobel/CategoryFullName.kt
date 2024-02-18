package com.uce.moviles.data.network.entities.nobel

import kotlinx.serialization.Serializable

@Serializable
data class CategoryFullName(
    val en: String,
    val no: String,
    val se: String
)