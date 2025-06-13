package com.example.recloth.composables

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recloth.R
import com.example.recloth.models.ClothingItem
import com.example.recloth.utils.JsonLoader

@Composable
fun LandingScreen(modifier: Modifier) {
    var selectedCategory by remember { mutableStateOf("shirts") }
    val context = LocalContext.current
    val clothingItems = remember(selectedCategory) { 
        JsonLoader.loadClothingItems(context, selectedCategory)
    }

    Box(modifier = Modifier) {
        Box {
            Image(painter = painterResource(id = R.drawable.backdrop), contentDescription = "Backdrop")
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.height(95.dp))
                Text("Welcome to", color = Color.White, fontSize = 50.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(10.dp))
                Text("ReCloth", color = Color.White, fontSize = 50.sp, fontWeight = FontWeight.Bold)
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 250.dp)
                .background(color = Color.White, shape = RoundedCornerShape(16.dp))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
            ) {
                CategoryImage(
                    resourceId = R.drawable.shirts,
                    category = "shirts",
                    selectedCategory = selectedCategory,
                    onCategorySelected = { selectedCategory = it }
                )
                CategoryImage(
                    resourceId = R.drawable.tshirts,
                    category = "tshirts",
                    selectedCategory = selectedCategory,
                    onCategorySelected = { selectedCategory = it }
                )
                CategoryImage(
                    resourceId = R.drawable.jackets,
                    category = "jackets",
                    selectedCategory = selectedCategory,
                    onCategorySelected = { selectedCategory = it }
                )
                CategoryImage(
                    resourceId = R.drawable.jeans,
                    category = "jeans",
                    selectedCategory = selectedCategory,
                    onCategorySelected = { selectedCategory = it }
                )
                CategoryImage(
                    resourceId = R.drawable.pants,
                    category = "pants",
                    selectedCategory = selectedCategory,
                    onCategorySelected = { selectedCategory = it }
                )
                CategoryImage(
                    resourceId = R.drawable.shoes,
                    category = "shoes",
                    selectedCategory = selectedCategory,
                    onCategorySelected = { selectedCategory = it }
                )
                CategoryImage(
                    resourceId = R.drawable.sarees,
                    category = "sarees",
                    selectedCategory = selectedCategory,
                    onCategorySelected = { selectedCategory = it }
                )
                CategoryImage(
                    resourceId = R.drawable.salwaar,
                    category = "salwaar",
                    selectedCategory = selectedCategory,
                    onCategorySelected = { selectedCategory = it }
                )
            }
            
            ClothingList(
                items = clothingItems,
                selectedCategory = selectedCategory,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
private fun CategoryImage(
    resourceId: Int,
    category: String,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit
) {
    Image(
        painter = painterResource(id = resourceId),
        contentDescription = "$category image",
        modifier = Modifier
            .size(135.dp)
            .padding(16.dp)
            .clickable { onCategorySelected(category) }
    )
}

@Preview(showBackground = true)
@Composable
fun LandingScreenPreview() {
    LandingScreen(modifier = Modifier)
}