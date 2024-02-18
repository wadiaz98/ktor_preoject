package com.uce.moviles.data.network.entities.nobel

import kotlinx.serialization.Serializable

@Serializable
data class LinkX(
    val action: String,
    val href: String,
    val rel: String,
    val types: String
)