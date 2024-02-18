package com.uce.moviles.data.network.entities.nobel

import kotlinx.serialization.Serializable

@Serializable
data class OrgName(
    val en: String,
    val no: String
)