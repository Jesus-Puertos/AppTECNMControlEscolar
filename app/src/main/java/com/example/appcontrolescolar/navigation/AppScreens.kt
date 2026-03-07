package com.example.appcontrolescolar.navigation

sealed class AppScreens(val route: String) {

    object Home : AppScreens("home")

    object Schedule : AppScreens("schedule")

    object Map : AppScreens("map")

    object Profile : AppScreens("profile")
}