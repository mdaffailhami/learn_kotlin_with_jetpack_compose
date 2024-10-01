package com.example.learnkotlinwithjetpackcompose.ui.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.learnkotlinwithjetpackcompose.ui.components.AppBar

@Composable
fun DetailsPage(navController: NavHostController, count: Int) {
    Scaffold(
        topBar = { AppBar(navController) }, modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Text(
                text = "$count",
                fontWeight = FontWeight.Bold,
                fontSize = 60.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}