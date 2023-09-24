package com.example.basictextfield2playground.signup

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text2.BasicSecureTextField
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basictextfield2playground.login.modifierBTFBorder
import com.example.basictextfield2playground.ui.theme.textStyleBodyLarge

/**
 * Showcases state observation, viewmodel
 */
@Composable
@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
fun SignUpScreen(
    modifier: Modifier = Modifier,
    signUpViewModel: SignUpViewModel = viewModel()
) {
    SignUpScreenScaffold {

        BasicTextField2(
            modifier = modifierBTFBorder,
            state = signUpViewModel.username,
            textStyle = textStyleBodyLarge
        )

        val userNameHasError by signUpViewModel.userNameHasError.collectAsStateWithLifecycle()

        if (userNameHasError) {
            Text(
                text = "Username not available. Please choose a different one.",
                color = Color.Red
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        // showcase textObfuscationMode
        /***
         * PasswordRevealFilter is an example of input transformation
         * MaxLengthFilter is an example of input transformation
         */
        /***
         * PasswordRevealFilter is an example of input transformation
         * MaxLengthFilter is an example of input transformation
         */
        val password = rememberTextFieldState(initialText = "")
        BasicSecureTextField(
            modifier = modifierBTFBorder,
            state = password,
            textStyle = textStyleBodyLarge
        )
    }
}
