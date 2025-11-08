package com.example.melodia.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Profile : Screen("profile")
    object DetailGroup : Screen("home/{musicId}") {
        fun createRoute(musicId: Int) = "home/$musicId"
    }
}