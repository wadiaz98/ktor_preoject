package com.uce.moviles.data.network.entities.nobel

import kotlinx.serialization.Serializable

@Serializable
data class NobelPrizeX(
    val awardYear: String,
    val category: Category,
    val categoryFullName: CategoryFullName,
    val dateAwarded: String,
    val laureates: List<Laureate>?=null,
    val links: List<LinkX>,
    val prizeAmount: Int,
    val prizeAmountAdjusted: Int
)