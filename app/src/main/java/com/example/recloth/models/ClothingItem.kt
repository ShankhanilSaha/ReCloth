package com.example.recloth.models

import kotlinx.serialization.Serializable

@Serializable
data class ClothingItem(
    val id: String,
    val name: String,
    val imageUrl: String,
    val category: String,
    val price: Double,
    val description: String
) 