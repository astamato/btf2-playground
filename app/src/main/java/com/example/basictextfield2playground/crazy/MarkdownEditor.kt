package com.example.basictextfield2playground.crazy

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.text2.input.insert
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
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.basictextfield2playground.signup.SignUpScreenScaffold
import com.example.basictextfield2playground.ui.theme.textStyleBodyLarge
import com.example.basictextfield2playground.uicomponents.modifierBTFBorder

/**
 * Showcases state observation, viewmodel
 */
@Composable
@OptIn(ExperimentalFoundationApi::class)
@PreviewLightDark
fun MarkdownEditor(
    modifier: Modifier = Modifier
) {

    val username = rememberTextFieldState("This is a bold text")

    SignUpScreenScaffold {
        Row(
            modifier = modifierBTFBorder
                .fillMaxWidth()
                .height(24.dp)
        ) {
            BasicTextField2(
                state = username,
                modifier = Modifier
                    .weight(.9f)
                    .align(Alignment.CenterVertically),
                textStyle = textStyleBodyLarge,
                lineLimits = TextFieldLineLimits.SingleLine,
            )
            IconButton(
                onClick = { username },
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(.1f)
                    .wrapContentSize()
            ) {
                Icon(Icons.Filled.Clear, "content description")
            }
        }


        Spacer(modifier = Modifier.height(4.dp))

        Row {
            Button(
                onClick = {
                    username.edit {
                        if (selectionInChars.length > 0) {
                            insert(selectionInChars.start, "**")
                            insert(selectionInChars.end, "**")
                        }
                    }
                },
                modifier = Modifier
                    .border(1.dp, Color.Gray, shape = RoundedCornerShape(8.dp))
                    .align(Alignment.CenterVertically)
                    .weight(.1f)
                    .wrapContentSize()
                    .clickable { username.edit { append("@gmail.com") } }
            ) {
                Text(text = "B", fontWeight = Bold)
            }
            Spacer(modifier = Modifier.width(8.dp))

        }
    }
}
