package com.example.basictextfield2playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.basictextfield2playground.form.FormScreen
import com.example.basictextfield2playground.login.LoginScreen
import com.example.basictextfield2playground.navigation.Screen
import com.example.basictextfield2playground.ui.theme.BasicTextField2PlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicTextField2PlaygroundTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppMainComposable()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BasicTextField2PlaygroundTheme {
        AppMainComposable()
    }
}

@Composable
fun AppMainComposable() {
    val navController = rememberNavController()

    Scaffold(
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = Screen.Login.route,
            Modifier.padding(innerPadding)
        ) {
            composable(Screen.Login.route) {
                LoginScreen(onLoginSuccess = {
                    navController.navigate(
                        Screen.Form.route
                    )
                })
            }
            composable(Screen.Form.route) { FormScreen() }
        }
    }
}
