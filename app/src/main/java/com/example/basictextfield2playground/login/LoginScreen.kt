package com.example.basictextfield2playground.login

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text2.BasicSecureTextField
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basictextfield2playground.ui.theme.textStyleBodyLarge

/***
 * Showcases basic API usage
 * basic styling just like BTF2 with textStyle, decoration box, cursor brush
 *
 *
 */
@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun LoginScreen(
    modifier: Modifier = Modifier,
    onLoginSuccess: () -> Unit = {},
//    loginViewModel: LoginViewModel = viewModel()
) {
    Column(modifier = modifier.padding(16.dp)) {
        val username = TextFieldState(initialText = "")
        BasicTextField2(
            state = username,
            textStyle = textStyleBodyLarge,
            decorationBox = @Composable {
                val interactionSource =
                    remember { MutableInteractionSource() }
                Column(Modifier.padding(4.dp)) {
                    OutlinedTextFieldDefaults.DecorationBox(
                        value = username.text.toString(),
                        innerTextField = it,
                        enabled = true,
                        singleLine = true,
                        visualTransformation = VisualTransformation.None,
                        interactionSource = interactionSource,
                        isError = false,
                        label = null,
                        placeholder = null,
                        leadingIcon = null,
                        trailingIcon = null,
                        colors = OutlinedTextFieldDefaults.colors(),
                        contentPadding = OutlinedTextFieldDefaults.contentPadding(),
                        container = {
                            OutlinedTextFieldDefaults.ContainerBox(
                                true,
                                false,
                                interactionSource,
                                OutlinedTextFieldDefaults.colors()
                            )
                        },
                    )
                }
            }
        )

        // showcase textObfuscationMode
        /***
         * PasswordRevealFilter is an example of input transformation
         * MaxLengthFilter is an example of input transformation
         */
        val password = TextFieldState(initialText = "")
        BasicSecureTextField(state = password, textStyle = textStyleBodyLarge)

        Button(onClick = onLoginSuccess) {
            Text("LOG IN")
        }
    }
}

/**
 * STEP 1
 */
@Composable
@Preview(showBackground = true)
fun LoginScreenOld(
    modifier: Modifier = Modifier,
    onLoginSuccess: () -> Unit = {},
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
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
        AcceptTermsAndConditions()
        Button(
            onClick = onLoginSuccess, modifier = Modifier
                .align(CenterHorizontally)
                .padding(32.dp)
        ) {
            Text("LOG IN")
        }
    }
}


/**
 * STEP 2
 */
@Composable
@Preview(showBackground = true)
fun LoginScreenBTFOld(
    modifier: Modifier = Modifier,
    onLoginSuccess: () -> Unit = {},
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        var username by remember { mutableStateOf("") }
        BasicTextField(
            modifier = modifier.fillMaxWidth(),
            value = username,
            onValueChange = { username = it }
        )

        var password by remember { mutableStateOf("") }
        BasicTextField(
            modifier = modifier.fillMaxWidth(),
            value = password,
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation()
        )
        AcceptTermsAndConditions()
        Button(
            onClick = onLoginSuccess, modifier = Modifier
                .align(CenterHorizontally)
                .padding(32.dp)
        ) {
            Text("LOG IN")
        }
    }
}



@Composable
@Preview
fun AcceptTermsAndConditions() {
    val annotatedString = buildAnnotatedString {
        append("I accept the ")
        withStyle(
            style = SpanStyle(
                textDecoration = TextDecoration.Underline,
                color = Color.Red,
                fontSize = 18.sp,
            )
        ) {
            append("terms and conditions")
        }
        append(".")
    }

    var isChecked by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { isChecked = it },
            modifier = Modifier.padding(8.dp)
        )
        Text(
            text = annotatedString
        )
    }
}