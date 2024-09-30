package com.example.learnkotlinwithjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnkotlinwithjetpackcompose.ui.theme.LearnKotlinWithJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            LearnKotlinWithJetpackComposeTheme { HomePage() }
        }
    }
}

@Preview
@Composable
fun Preview() {
    LearnKotlinWithJetpackComposeTheme { HomePage() }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage() {
    var count by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("MDI Counter") },
                actions = {
                    IconButton(onClick = { /* Do something */ }) {
                        Icon(Icons.Default.MoreVert, contentDescription = "Menu")
                    }
                },
            )
        },
        modifier = Modifier.fillMaxSize()
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
            Row(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .offset((-30).dp, (-30).dp)
            ) {
                FloatingActionButton(
                    onClick = { if (count > 0) count -= 1 },
                ) {
                    Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, "Add")
                }

                Spacer(modifier = Modifier.width(20.dp))

                FloatingActionButton(
                    onClick = { count += 1 },
                ) {
                    Icon(Icons.AutoMirrored.Filled.KeyboardArrowRight, "Add")
                }
            }
        }
    }
}