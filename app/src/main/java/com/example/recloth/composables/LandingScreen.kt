package com.example.recloth.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recloth.R

@Composable
fun LandingScreen(modifier: Modifier) {
    Box(modifier = Modifier) {
        Box {
            Image(painter = painterResource(id = R.drawable.backdrop),contentDescription = "Backdrop")
            Column(modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,){
                Spacer(modifier = Modifier.height(95.dp))
                Text("Welcome to", color = Color.White, fontSize = 50.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(10.dp))
                Text("ReCloth", color = Color.White, fontSize = 50.sp, fontWeight = FontWeight.Bold)
            }
        }
        Column(modifier = Modifier.fillMaxSize().padding(top = 250.dp)
            .background(color = Color.White,shape = RoundedCornerShape(16.dp))){
            Row(modifier=Modifier.fillMaxWidth().horizontalScroll(rememberScrollState())) {
                Image(painter = painterResource(id = R.drawable.shirts),
                    contentDescription = "shirts image",
                    modifier = Modifier.size(135.dp).padding(16.dp)
                        .clickable(true){
                            /*TODO*/
                        }
                )
                Image(painter = painterResource(id = R.drawable.tshirts),
                    contentDescription = "t-shirts image",
                    modifier = Modifier.size(135.dp).padding(16.dp)
                        .clickable(true){
                            /*TODO*/
                        }
                )
                Image(painter = painterResource(id = R.drawable.jackets),
                    contentDescription = "jackets image",
                    modifier = Modifier.size(135.dp).padding(16.dp)
                        .clickable(true){
                            /*TODO*/
                        }
                )
                Image(painter = painterResource(id = R.drawable.jeans),
                    contentDescription = "jeans image",
                    modifier = Modifier.size(135.dp).padding(16.dp)
                        .clickable(true){
                            /*TODO*/
                        }
                )
                Image(painter = painterResource(id = R.drawable.pants),
                    contentDescription = "pants image",
                    modifier = Modifier.size(135.dp).padding(16.dp)
                        .clickable(true){
                            /*TODO*/
                        }
                )
                Image(painter = painterResource(id = R.drawable.shoes),
                    contentDescription = "shoes image",
                    modifier = Modifier.size(135.dp).padding(16.dp)
                        .clickable(true){
                            /*TODO*/
                        }
                )
                Image(painter = painterResource(id = R.drawable.sarees),
                    contentDescription = "sarees image",
                    modifier = Modifier.size(135.dp).padding(16.dp)
                        .clickable(true){
                            /*TODO*/
                        }
                )
                Image(painter = painterResource(id = R.drawable.salwaar),
                    contentDescription = "salwar image",
                    modifier = Modifier.size(135.dp).padding(16.dp)
                        .clickable(true){
                            /*TODO*/
                        }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LandingScreenPreview() {
    LandingScreen(modifier = Modifier)
}