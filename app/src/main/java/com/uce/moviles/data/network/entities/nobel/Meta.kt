package com.uce.moviles.data.network.entities.nobel

import kotlinx.serialization.Serializable

@Serializable
data class Meta(
    val count: Int,
    val disclaimer: String,
    val license: String,
    val limit: Int,
    val offset: Int,
    val terms: String
)