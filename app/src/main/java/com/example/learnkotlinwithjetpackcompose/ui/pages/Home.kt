package com.example.learnkotlinwithjetpackcompose.ui.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.learnkotlinwithjetpackcompose.Page
import com.example.learnkotlinwithjetpackcompose.ui.components.AppBar

@Composable
fun HomePage(
    count: Int, navController: NavHostController, onIncrement: () -> Unit, onDecrement: () -> Unit
) {
    Scaffold(
        topBar = { AppBar(navController) }, modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.align(Alignment.Center)
            ) {
                Text(
                    text = "$count",
                    fontWeight = FontWeight.Bold,
                    fontSize = 60.sp,
                )
                Button(onClick = { navController.navigate(Page.Details.route) }) {
                    Text("Go to Details")
                }
            }
            Row(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .offset((-30).dp, (-30).dp)
            ) {
                FloatingActionButton(
                    onClick = onDecrement,
                ) {
                    Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, "Subtract")
                }

                Spacer(modifier = Modifier.width(20.dp))

                FloatingActionButton(
                    onClick = onIncrement,
                ) {
                    Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, "Add")
                }
            }
        }
    }
}