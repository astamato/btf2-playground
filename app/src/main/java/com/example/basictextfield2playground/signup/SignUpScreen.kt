package com.example.basictextfield2playground.signup

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text2.BasicSecureTextField
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.text2.input.TextObfuscationMode
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.foundation.text2.input.selectAll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basictextfield2playground.uicomponents.modifierBTFBorder
import com.example.basictextfield2playground.ui.theme.textStyleBodyLarge

/**
 * Showcases state observation, viewmodel
 */
@Composable
@OptIn(ExperimentalFoundationApi::class)
@PreviewLightDark
fun SignUpScreen(
    modifier: Modifier = Modifier, signUpViewModel: SignUpViewModel = viewModel()
) {
    SignUpScreenScaffold {
        Row(
            modifier = modifierBTFBorder
                .fillMaxWidth()
                .height(24.dp)
        ) {
            BasicTextField2(
                state = signUpViewModel.username,
                modifier = Modifier
                    .weight(.9f)
                    .align(CenterVertically),
                textStyle = textStyleBodyLarge,
                lineLimits = TextFieldLineLimits.SingleLine,
            )
            IconButton(
                onClick = { signUpViewModel.clearField() },
                modifier = Modifier
                    .align(CenterVertically)
                    .weight(.1f)
                    .wrapContentSize()
            ) {
                Icon(Icons.Filled.Clear, "content description")
            }
        }

//        LaunchedEffect(Unit) {
//            signUpViewModel.username.forEachTextValue {
//                Log.w("TEST", "User input: $it")
//            }
//        }
//
//
        LaunchedEffect(Unit) {
            signUpViewModel.validateUsername()
        }


//        val userNameHasError by signUpViewModel.userNameHasErrorWithSelect.collectAsStateWithLifecycle()

//        if (userNameHasError) {
        if (signUpViewModel.userNameHasError) {
            Text(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth()
                    .align(Start),
                text = "Username not available. Please choose a different one.",
                color = Red
            )
        }

        Spacer(modifier = Modifier.height(4.dp))

        // showcase textObfuscationMode
        val password = rememberTextFieldState(initialText = "")
        BasicSecureTextField(
            modifier = modifierBTFBorder.fillMaxWidth(),
            state = password,
            textStyle = textStyleBodyLarge,
//            textObfuscationMode = TextObfuscationMode.Visible
        )
    }
}
