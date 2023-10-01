package com.example.basictextfield2playground.email

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.coerceIn
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.basictextfield2playground.uicomponents.LabelText
import kotlinx.coroutines.launch
import kotlinx.coroutines.selects.select
import kotlin.math.roundToInt

/**
 * Showcases a very long text, with styles
 * Showcases multiline
 * Showcase search by keyword with focus requester
 * Showcase TextField buffer? manual/declarative editing?
 *
 */
@OptIn(ExperimentalFoundationApi::class)
@PreviewLightDark
@Composable
fun TextBoxForm(modifier: Modifier = Modifier) {
    val focusRequester = remember { FocusRequester() }
    val textBox = rememberTextFieldState(
        initialText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus non erat ac justo tincidunt suscipit. Sed ac dolor quam. Sed bibendum lacus a tellus egestas venenatis. Sed malesuada ipsum eu urna bibendum, at dignissim turpis rhoncus. Vivamus consequat, ante a bibendum dictum, est tortor blandit augue, non facilisis odio dolor vel velit. Suspendisse potenti. Fusce laoreet semper ipsum, vel hendrerit ante aliquet ac. Maecenas semper urna in sapien tincidunt tincidunt.\n" +
                "\n" +
                "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed in bibendum dolor. Sed commodo libero nec tincidunt vulputate. Vestibulum faucibus, libero sed bibendum\n"
    )
    val search = rememberTextFieldState(initialText = "")
//    val scrollState = rememberScrollState()
//
//    val scope = rememberCoroutineScope()
    Column(modifier.padding(16.dp)) {
        LabelText(label = "")

        Row(verticalAlignment = CenterVertically) {
            BasicTextField2(
                state = search,
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                    .padding(8.dp)
                    .weight(.6f),
                textStyle = TextStyle(fontSize = 16.sp),
                lineLimits = TextFieldLineLimits.SingleLine,
            )
Button(
    modifier = Modifier.padding(start = 8.dp),
    onClick = {
        val target = search.text

        val results =
            findAllSubstringOccurrences(textBox.text.toString(), target.toString())

        textBox.edit {
            if (results.isNotEmpty()) {
                selectCharsIn(
                    TextRange(
                        results.first().first,
                        results.first().second + 1
                    ).coerceIn(0, textBox.text.length)
                )
            }

            focusRequester.requestFocus()

//                        scope.launch {
//                            scrollState.scrollTo(results.first().first)
//                        }
        }
    }
) {
    Text(text = "Search")
}
}

        Spacer(modifier = Modifier.height(8.dp))

        BasicTextField2(
            state = textBox,
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.LightGray, RoundedCornerShape(8.dp))
                .padding(8.dp)
                .focusRequester(focusRequester),
            textStyle = TextStyle(fontSize = 16.sp),
            lineLimits = TextFieldLineLimits.MultiLine(3, 5),
//            scrollState = scrollState,
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row {
            val emoji1 = "❤️"
            Button(
                onClick = { textBox.edit { append(emoji1) } },
                modifier
                    .wrapContentSize()
                    .align(CenterVertically)
                    .weight(.3f)
            ) {
                Text(emoji1)
            }
            val emoji2 = "\uD83D\uDE02"
            Button(
                onClick = { textBox.edit { append(emoji2) } },
                modifier
                    .wrapContentSize()
                    .align(CenterVertically)
                    .weight(.3f)
            ) {
                Text(emoji2)
            }
            val emoji3 = "\uD83D\uDC4D"
            Button(
                onClick = { textBox.edit { append(emoji3) } },
                modifier
                    .wrapContentSize()
                    .align(CenterVertically)
                    .weight(.3f)
            ) {
                Text(emoji3)
            }
        }
    }
}


fun findAllSubstringOccurrences(mainString: String, substring: String): List<Pair<Int, Int>> {
    val occurrences = mutableListOf<Pair<Int, Int>>()
    var startIndex = 0

    while (startIndex < mainString.length) {
        val foundIndex = mainString.indexOf(substring, startIndex)
        if (foundIndex == -1) {
            break // No more occurrences found
        }
        val endIndex = foundIndex + substring.length - 1
        occurrences.add(Pair(foundIndex, endIndex))
        // Move the startIndex past the current occurrence
        startIndex = foundIndex + 1
    }
    return occurrences
}
