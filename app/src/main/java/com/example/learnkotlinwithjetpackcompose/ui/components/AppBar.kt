package com.example.learnkotlinwithjetpackcompose.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(navController: NavHostController) {
    TopAppBar(
        title = { Text("MDI Counter") },
        actions = {
            IconButton(onClick = { /* Do something */ }) {
                Icon(Icons.Default.MoreVert, contentDescription = "Menu")
            }
        },
        navigationIcon = {
            // Show back button if there's more than one entry in the backstack
            val canPop = navController.previousBackStackEntry != null

            if (canPop) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        }
    )
}