package com.uce.moviles.data.network.entities.nobel

import kotlinx.serialization.Serializable

@Serializable
data class Laureate(
    val fullName: FullName?,
    val id: String,
    val knownName: KnownName,
    val links: List<LinkX>,
)