package com.example.basictextfield2playground.navigation

sealed class Screen(
    val route: String
) {
    object Login : Screen("Login")
    object Form : Screen("form")
}
