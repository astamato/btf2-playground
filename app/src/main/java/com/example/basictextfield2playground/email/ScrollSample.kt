package com.example.basictextfield2playground.email

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

/**
 * From the documentation
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
@PreviewLightDark
fun SharedHoistedScroll() {
    val state1 =
        rememberTextFieldState("When content gets long, this field should scroll horizontally")
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()
    Column(Modifier.padding(32.dp)) {
        BasicTextField2(
            state = state1,
            scrollState = scrollState,
            textStyle = TextStyle(fontSize = 24.sp),
            modifier = Modifier.fillMaxWidth(),
            lineLimits = TextFieldLineLimits.SingleLine
        )

        Slider(
            value = scrollState.value.toFloat(),
            onValueChange = {
                coroutineScope.launch { scrollState.scrollTo(it.roundToInt()) }
            },
            valueRange = 0f..scrollState.maxValue.toFloat()
        )
    }
}
