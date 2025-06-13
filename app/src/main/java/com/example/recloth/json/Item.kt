package com.example.recloth.json

import kotlinx.serialization.Serializable

@Serializable
data class Item(
    val names: String,
    val images: String?,
    val prices: String?
)
