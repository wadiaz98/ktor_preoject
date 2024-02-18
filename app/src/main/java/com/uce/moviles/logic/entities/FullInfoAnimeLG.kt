package com.uce.moviles.logic.usercases.jikan.entities

import kotlinx.serialization.Serializable

@Serializable
data class FullInfoAnimeLG (
    var id: Int = -1,
    var name: String = "",
    var small_image: String = "",
    var big_image: String = "",
    var synapsis :String = ""
)