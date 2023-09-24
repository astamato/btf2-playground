package com.example.basictextfield2playground.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun TermsAndConditionsLabel() {
    val underline = SpanStyle(
        textDecoration = TextDecoration.Underline,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF3C0A96),
    )
    val annotatedString = buildAnnotatedString {
        append("I accept the ")
        withStyle(
            style = underline
        ) {
            append("Terms of Use")
        }
        append(" and consent to the ")
        withStyle(
            style = underline
        ) {
            append("Privacy Policy")
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
