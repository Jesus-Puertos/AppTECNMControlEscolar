package com.example.appcontrolescolar.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.appcontrolescolar.navigation.AppScreens

@Composable
fun BottomBar(navController: NavHostController) {
    val items = listOf(
        AppScreens.Home,
        AppScreens.Schedule,
        AppScreens.Map,
        AppScreens.Profile
    )

    val labels = listOf("Inicio", "Horario", "Mapa", "Perfil")
    val icons = listOf(
        Icons.Outlined.Home,
        Icons.Outlined.DateRange,
        Icons.Outlined.LocationOn,
        Icons.Outlined.AccountCircle
    )

    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    NavigationBar {
        items.forEachIndexed { index, screen ->
            NavigationBarItem(
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = icons[index],
                        contentDescription = labels[index]
                    )
                },
                label = {
                    Text(labels[index])
                }
            )
        }
    }
}