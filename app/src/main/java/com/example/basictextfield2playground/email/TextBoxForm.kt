package com.example.basictextfield2playground.email

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basictextfield2playground.uicomponents.LabelText

/**
 * Showcases a very long text, with styles
 * Showcases multiline
 * Showcase search by keyword with hoisted scroll state
 * Showcase TextField buffer? manual/declarative editing?
 *
 */
@OptIn(ExperimentalFoundationApi::class)
@PreviewLightDark
@Composable
fun TextBoxForm(modifier: Modifier = Modifier) {

    val textBox = rememberTextFieldState(initialText = "")
    val scrollState = rememberScrollState()
    Column(modifier.padding(16.dp)) {

        LabelText(label = "")

        BasicTextField2(
            state = textBox,
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.LightGray, RoundedCornerShape(6.dp)),
            textStyle = TextStyle(fontSize = 16.sp),
            lineLimits = TextFieldLineLimits.MultiLine(3, 5),
            scrollState = scrollState,
        )

        Button(onClick = { /*TODO*/ }) {

        }
    }
}
