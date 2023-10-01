package com.example.basictextfield2playground.crazy

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.CodepointTransformation
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.text2.input.mask
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.basictextfield2playground.uicomponents.modifierBTFBorder

/**
 * I'm not sure why I'd want this over Secure text field
 */
@OptIn(ExperimentalFoundationApi::class)
@PreviewLightDark
@Composable
fun CodepointTransformationTest() {
    val cvv = rememberTextFieldState(initialText = "")
    BasicTextField2(
        cvv,
        lineLimits = TextFieldLineLimits.SingleLine,
        modifier = modifierBTFBorder.fillMaxWidth(),
        codepointTransformation = CodepointTransformation.mask('?')
    )
}
