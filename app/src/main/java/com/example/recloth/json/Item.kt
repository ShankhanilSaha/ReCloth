package com.example.recloth.json

import kotlinx.serialization.Serializable

@Serializable
data class Item(val name:String,val price:String,val image: String)
