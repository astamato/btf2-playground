package com.example.basictextfield2playground.crazy

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
@PreviewLightDark
fun BasicTextField2UndoSample() {
    val state = rememberTextFieldState()

    Column(
        Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Spacer(modifier = Modifier.height(32.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(
                onClick = { state.undoState.undo() },
                enabled = state.undoState.canUndo
            ) {
                Text("Undo")
            }

            Button(
                onClick = { state.undoState.redo() },
                enabled = state.undoState.canRedo
            ) {
                Text("Redo")
            }

            Button(
                onClick = { state.undoState.clearHistory() },
                enabled = state.undoState.canUndo || state.undoState.canRedo
            ) {
                Text("Clear History")
            }
        }

        BasicTextField2(
            state = state,
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.LightGray, RoundedCornerShape(6.dp))
                .padding(8.dp),
            textStyle = TextStyle(fontSize = 16.sp),
            lineLimits = TextFieldLineLimits.MultiLine(3, 5)
        )

        if (state.undoState.canUndo) {
            Text(text = "There are actions to undo")
        }
    }
}
