package com.example.recloth.utils

import android.content.Context
import android.util.Log
import com.example.recloth.json.Item
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable
import java.io.IOException

object JsonLoader {
    private const val TAG = "JsonLoader"

    fun loadClothingItems(context: Context, category: String): List<Item> {
        return try {
            val jsonString = context.assets
                .open("$category.json")
                .bufferedReader()
                .use { it.readText() }
            
            if (jsonString.isBlank()) {
                Log.e(TAG, "Empty JSON file for category: $category")
                return emptyList()
            }

            Json.decodeFromString<List<Item>>(jsonString)
        } catch (e: IOException) {
            Log.e(TAG, "Error reading JSON file for category: $category", e)
            emptyList()
        } catch (e: Exception) {
            Log.e(TAG, "Error parsing JSON for category: $category", e)
            emptyList()
        }
    }
} 