package com.uce.moviles.data.network.entities.nobel

import kotlinx.serialization.Serializable

@Serializable
data class NobelPrize(
    val links: Links,
    val meta: Meta,
    val nobelPrizes: List<NobelPrizeX>
)