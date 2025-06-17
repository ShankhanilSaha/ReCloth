package com.example.recloth.composables

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.recloth.json.Item

@Composable
fun ClothingList(
    items: List<Item>,
    selectedCategory: String,
    modifier: Modifier = Modifier
) {
    val gridState = rememberLazyGridState()
    val context = LocalContext.current
    
    // Filter items to only include those with all required attributes
    val validItems = remember(items) {
        items.filter { item ->
            item.names.isNotBlank() && 
            item.images != null && 
            item.images.isNotBlank() && 
            item.prices != null && 
            item.prices.isNotBlank()
        }
    }
    
    // Scroll to top when category changes
    LaunchedEffect(selectedCategory) {
        gridState.scrollToItem(0)
    }

    if (validItems.isEmpty()) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "No items found in $selectedCategory category")
        }
        return
    }
    
    LazyVerticalGrid(
        state = gridState,
        columns = GridCells.Fixed(2),
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = validItems,
            key = { it.names + it.images } // Add key for better item recycling
        ) { item ->
            ClothingItemCard(item = item, context = context)
        }
    }
}

@Composable
fun ClothingItemCard(item: Item, context: Context) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color.LightGray)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(context)
                        .data(item.images)
                        .crossfade(true)
                        .size(300) // Limit image size
                        .build(),
                    contentDescription = item.names,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = item.names,
                    maxLines = 1
                )
                Text(
                    text = "${item.prices?.replace("Rs.", "")?.trim() ?: ""} 🪙",
                    maxLines = 1
                )
            }
        }
    }
} 