package com.example.basictextfield2playground.navigation

@Deprecated("Run each screen from preview")
sealed class Screen(
    val route: String
) {
    data object Login : Screen("Login")
    data object Form : Screen("form")
}
