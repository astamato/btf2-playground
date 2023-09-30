package com.example.basictextfield2playground.login

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text2.BasicSecureTextField
import androidx.compose.foundation.text2.input.TextObfuscationMode
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.basictextfield2playground.R
import com.example.basictextfield2playground.ui.theme.textStyleBodyLarge
import com.example.basictextfield2playground.uicomponents.modifierBTFBorder

@OptIn(ExperimentalFoundationApi::class)
@Composable
@PreviewLightDark
fun PasswordFieldTapToReveal(modifier: Modifier = Modifier) {

    var textObfuscationMode by remember { mutableStateOf(TextObfuscationMode.RevealLastTyped) }
    val password = rememberTextFieldState(initialText = "onepassword")
    var icon by remember { mutableIntStateOf(R.drawable.visibility_off_24px ) }

    Row(modifier.padding(16.dp)) {
        BasicSecureTextField(
            modifier = modifierBTFBorder,
            state = password,
            textStyle = textStyleBodyLarge,
            textObfuscationMode = textObfuscationMode
        )
        Icon(painterResource(id = icon),
            "content description",
            modifier = Modifier
                .pointerInput(Unit) {
                    awaitPointerEventScope {
                        while (true) {
                            val event = awaitPointerEvent()
                            if (event.type == PointerEventType.Press) {
                                textObfuscationMode = TextObfuscationMode.Visible
                                icon = R.drawable.visibility_24px
                            }
                            if (event.type == PointerEventType.Release) {
                                textObfuscationMode = TextObfuscationMode.RevealLastTyped
                                icon = R.drawable.visibility_off_24px
                            }
                        }
                    }
                }
                .align(CenterVertically)
                .padding(start = 8.dp))
    }
}
