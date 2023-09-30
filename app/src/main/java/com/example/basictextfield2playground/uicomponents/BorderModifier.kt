package com.example.basictextfield2playground.uicomponents

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

val modifierBTFBorder = Modifier
    .border(1.dp, Color.Gray, shape = RoundedCornerShape(8.dp))
    .padding(8.dp)
