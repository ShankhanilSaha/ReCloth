package com.example.recloth.composables

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RecycleScreen(
    onBackClick: () -> Unit = {}
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            Spacer(modifier = Modifier.height(56.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back")
                }
                Text(text = "Return", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                SectionTitle("🧥 What is ReCloth?")
                SectionText("ReCloth is a sustainable fashion and recycling app designed to reduce textile waste by helping users responsibly recycle or donate unused clothing. We aim to make eco-conscious living easy, accessible, and rewarding through technology.")

                Spacer(modifier = Modifier.height(16.dp))

                SectionTitle("♻️ Why It Matters")
                SectionText("Millions of tons of clothing end up in landfills every year. Most of it could be reused, repurposed, or recycled. ReCloth empowers users to take action — not just for their closet, but for the planet.")

                Spacer(modifier = Modifier.height(16.dp))

                SectionTitle("📦 How It Works")
                SectionText(
                    "Using ReCloth is simple:\n" +
                            "• Select the clothes you want to recycle or donate\n" +
                            "• Schedule a pickup or drop-off\n" +
                            "• Track your recycling history and environmental impact\n\n" +
                            "We've partnered with certified recycling agencies and NGOs to ensure your clothes are handled responsibly."
                )

                Spacer(modifier = Modifier.height(16.dp))

                SectionTitle("🎁 Earn & Redeem Points")
                SectionText(
                    "Every time you recycle clothes through ReCloth, you earn Green Points based on the quantity and quality of the items.\n\n" +
                            "You can redeem these points in our in-app store to:\n" +
                            "• Get discounts on new sustainable clothing brands\n" +
                            "• Buy upcycled fashion products\n" +
                            "• Access exclusive rewards and eco-friendly merchandise\n\n" +
                            "It's our way of saying thank you for helping the planet."
                )

                Spacer(modifier = Modifier.height(16.dp))

                SectionTitle("🌍 Join the Movement")
                SectionText("ReCloth isn't just an app — it's a movement toward a circular fashion future. Whether you're clearing your wardrobe or shopping sustainably, you're making a difference.")
                Spacer(modifier = Modifier.height(32.dp))
                Button(onClick = {/*TODO*/},modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Request Pickup")
            }
            }
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        color = Color.Black
    )
}

@Composable
fun SectionText(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        color = Color.Black
    )
}

@Preview(showBackground = true)
@Composable
fun RecycleScreenPreview() {
    RecycleScreen(onBackClick = {})
}