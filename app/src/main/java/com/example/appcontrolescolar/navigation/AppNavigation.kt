package com.example.appcontrolescolar.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appcontrolescolar.ui.components.BottomBar
import com.example.appcontrolescolar.ui.screens.HomeScreen
import com.example.appcontrolescolar.ui.screens.MapScreen
import com.example.appcontrolescolar.ui.screens.ProfileScreen
import com.example.appcontrolescolar.ui.screens.ScheduleScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBar(navController)
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = AppScreens.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(AppScreens.Home.route) { HomeScreen() }
            composable(AppScreens.Schedule.route) { ScheduleScreen() }
            composable(AppScreens.Map.route) { MapScreen() }
            composable(AppScreens.Profile.route) { ProfileScreen() }
        }
    }
}