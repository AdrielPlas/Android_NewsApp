package com.example.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.ui.theme.NewsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NewsApp()
                }
            }
        }
    }
}

@Composable
fun NewsApp(){
    var newSearched by remember {
        mutableStateOf("")
    }
    var newsList = remember {
        mutableListOf("El presidente de EE.UU. no muestra signos de arrepentimiento...", "Bañarse en la piscina del desierto de Cleopatra", " Gigantes tecnológicos", "El rover de Marte envía")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Top Bar
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 26.dp),
            horizontalArrangement = Arrangement.Center
        ){
            OutlinedTextField(
                value = newSearched,
                onValueChange = {

                },
                placeholder = {
                    Text(
                        text = "Buscar"
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Buscar"
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(26.dp)
            )
        }
        // Seccion Tabs
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = "Noticias",
                modifier = Modifier
                    .padding(8.dp),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Eventos",
                modifier = Modifier
                    .padding(8.dp),
                fontSize = 25.sp,
                color = Color.Gray
            )
            Text(
                text = "Clima",
                modifier = Modifier
                    .padding(8.dp),
                fontSize = 25.sp,
                color = Color.Gray
            )
        }
        // Ultimas noticas
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text(
                text = "Ultimas noticias",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            LazyRow {
                items(newsList){ n ->
                    LastNews(n)
                }
            }
        }

        // Alrededor del mundo
        Column {
            Text(
                text = "Alrededor del mundo",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier
                    .padding(bottom = 14.dp)
            )
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxSize(),
                columns = GridCells.Fixed(2)
            ) {
                items(newsList){ news ->
                    NewsCard(news)
                }
            }
        }

    }
}

@Composable
fun LastNews(new: String) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .width(280.dp)
            .height(180.dp)
            .padding(top = 10.dp, bottom = 10.dp, end = 10.dp),
        colors = CardDefaults.cardColors(Color.Blue)
    ) {
        Column (
            modifier = Modifier
                .padding(10.dp)
        ){
            Text(
                text = new,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(top = 28.dp, bottom = 8.dp)
                    .weight(1f)
            )
            Text(
                text = "febrero 08 - 2024",
                color = Color.White
            )
        }
    }
}

@Composable
fun NewsCard(news : String){
    Card (
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .height(200.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(Color.Gray)

        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsAppTheme {
        NewsApp()
    }
}