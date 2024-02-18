package com.uce.moviles.data.network.entities.nobel

data class NobelPrizeX(
    val awardYear: String,
    val category: Category,
    val categoryFullName: CategoryFullName,
    val dateAwarded: String,
    val laureates: List<Laureate>,
    val links: List<LinkX>,
    val prizeAmount: Int,
    val prizeAmountAdjusted: Int
)