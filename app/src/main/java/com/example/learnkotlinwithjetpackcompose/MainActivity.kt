package com.example.learnkotlinwithjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learnkotlinwithjetpackcompose.ui.pages.DetailsPage
import com.example.learnkotlinwithjetpackcompose.ui.pages.HomePage
import com.example.learnkotlinwithjetpackcompose.ui.theme.LearnKotlinWithJetpackComposeTheme

enum class Page(val route: String) {
    Home("home"),
    Details("details"),
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { MyApp() }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()

    var count by remember { mutableIntStateOf(0) }

    LearnKotlinWithJetpackComposeTheme {
        NavHost(navController = navController, startDestination = Page.Home.route) {
            composable(Page.Home.route) {
                HomePage(
                    count = count,
                    navController = navController,
                    onIncrement = { count++ },
                    onDecrement = { if (count > 0) count-- },
                )
            }
            composable(Page.Details.route) {
                DetailsPage(
                    count = count,
                    navController = navController,
                )
            }
        }
    }
}