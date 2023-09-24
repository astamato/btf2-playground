package com.example.basictextfield2playground.login

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text2.BasicSecureTextField
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basictextfield2playground.ui.theme.textStyleBodyLarge

/***
 * Showcases basic API usage
 * basic styling just like BTF2 with textStyle, decoration box, cursor brush
 */
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun LoginScreenContent(
    modifier: Modifier = Modifier,
    onLoginSuccess: () -> Unit = {},
//    loginViewModel: LoginViewModel = viewModel()
) {
    LoginScreenScaffold {

        val username = TextFieldState(initialText = "")
        BasicTextField2(
            state = username,
            textStyle = textStyleBodyLarge,
//            decorationBox = @Composable {
//                val interactionSource =
//                    remember { MutableInteractionSource() }
//                Column(Modifier.padding(4.dp)) {
//                    OutlinedTextFieldDefaults.DecorationBox(
//                        value = username.text.toString(),
//                        innerTextField = it,
//                        enabled = true,
//                        singleLine = true,
//                        visualTransformation = VisualTransformation.None,
//                        interactionSource = interactionSource,
//                        isError = false,
//                        label = null,
//                        placeholder = null,
//                        leadingIcon = null,
//                        trailingIcon = null,
//                        colors = OutlinedTextFieldDefaults.colors(),
//                        contentPadding = OutlinedTextFieldDefaults.contentPadding(),
//                        container = {
//                            OutlinedTextFieldDefaults.ContainerBox(
//                                true,
//                                false,
//                                interactionSource,
//                                OutlinedTextFieldDefaults.colors()
//                            )
//                        },
//                    )
//                }
//            }
        )

        // showcase textObfuscationMode
        /***
         * PasswordRevealFilter is an example of input transformation
         * MaxLengthFilter is an example of input transformation
         */
        val password = TextFieldState(initialText = "")
        BasicSecureTextField(state = password, textStyle = textStyleBodyLarge)
    }
}

/**
 * STEP 1
 */
@Composable
@Preview(showBackground = true)
fun LoginScreenTF(
    modifier: Modifier = Modifier,
    onLoginSuccess: () -> Unit = {},
) {
    LoginScreenScaffold {
        var username by remember { mutableStateOf("") }
        TextField(
            label = {
                Text(text = "username")
            },
            modifier = modifier.fillMaxWidth(),
            value = username,
            onValueChange = { username = it }
        )

        var password by remember { mutableStateOf("") }
        TextField(
            label = {
                Text(text = "password")
            },
            modifier = modifier.fillMaxWidth(),
            value = password,
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation()
        )
    }
}

/**
 * STEP 2
 */
@Composable
@Preview(showBackground = true)
fun LoginScreenBTF(
    modifier: Modifier = Modifier,
    onLoginSuccess: () -> Unit = {},
) {
    val modifierBTF = Modifier
        .fillMaxWidth()
        .border(1.dp, Color.Gray, shape = RoundedCornerShape(8.dp))
        .padding(8.dp)
    LoginScreenScaffold {
        var username by remember { mutableStateOf("") }
        BasicTextField(
            modifier = modifier.then(modifierBTF),
            value = username,
            onValueChange = { username = it }
        )

        Spacer(modifier = Modifier.height(4.dp))

        var password by remember { mutableStateOf("") }
        BasicTextField(
            modifier = modifier.then(modifierBTF),
            value = password,
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation()
        )
    }
}
