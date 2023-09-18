package com.example.basictextfield2playground.login

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text2.BasicSecureTextField
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

/***
 * Showcases basic API usage
 * basic styling just like BTF2 with textStyle, decoration box, cursor brush
 *
 *
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    modifier: Modifier = Modifier,
    loginViewModel: LoginViewModel = viewModel()
) {
    Column(modifier = modifier.padding(16.dp)) {
        val username = TextFieldState(initialText = "")
        BasicTextField2(state = username)

        // showcase textObfuscationMode
        /***
         * PasswordRevealFilter is an example of input transformation
         * MaxLengthFilter is an example of input transformation
         */
        val password = TextFieldState(initialText = "")
        BasicSecureTextField(state = password)

        Button(onClick = onLoginSuccess) {
            Text("LOG IN")
        }
    }
}
