package com.example.basictextfield2playground.email

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
    val search = rememberTextFieldState(initialText = "")
    val scrollState = rememberScrollState()

    Column(modifier.padding(16.dp)) {
        LabelText(label = "")

        BasicTextField2(
            state = search,
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp)).padding(8.dp),
            textStyle = TextStyle(fontSize = 16.sp),
            lineLimits = TextFieldLineLimits.SingleLine,
        )

        Spacer(modifier = Modifier.height(8.dp))

        BasicTextField2(
            state = textBox,
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp)).padding(8.dp),
            textStyle = TextStyle(fontSize = 16.sp),
            lineLimits = TextFieldLineLimits.MultiLine(3, 5),
            scrollState = scrollState,
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row {
            val emoji1 = "❤️"
            Button(
                onClick = { textBox.edit { append(emoji1) } },
                modifier
                    .wrapContentSize()
                    .align(Alignment.CenterVertically)
                    .weight(.3f)
            ) {
                Text(emoji1)
            }
            val emoji2 = "\uD83D\uDE02"
            Button(
                onClick = { textBox.edit { append(emoji2) } },
                modifier
                    .wrapContentSize()
                    .align(Alignment.CenterVertically)
                    .weight(.3f)
            ) {
                Text(emoji2)
            }
            val emoji3 = "\uD83D\uDC4D"
            Button(
                onClick = { textBox.edit { append(emoji3) } },
                modifier
                    .wrapContentSize()
                    .align(Alignment.CenterVertically)
                    .weight(.3f)
            ) {
                Text(emoji3)
            }
        }
    }
}
