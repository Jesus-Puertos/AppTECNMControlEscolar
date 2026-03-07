package com.example.appcontrolescolar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.appcontrolescolar.navigation.AppNavigation
import com.example.appcontrolescolar.ui.theme.AppControlEscolarTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            AppControlEscolarTheme {

                AppNavigation()

            }

        }
    }
}