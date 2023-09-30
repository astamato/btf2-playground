package com.example.basictextfield2playground.uicomponents

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.basictextfield2playground.ui.theme.fontFamilyDefault

@Composable
fun LabelText(label: String, modifier: Modifier = Modifier) {
    Text(
        text = label,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = fontFamilyDefault
    )
}
