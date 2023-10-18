package com.example.basictextfield2playground.signup

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.basictextfield2playground.ui.theme.textStyleBodyLarge
import com.example.basictextfield2playground.uicomponents.modifierBTFBorder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf


//@OptIn(ExperimentalFoundationApi::class)
//@Composable
//fun EmailCompleterRow(modifier: Modifier =Modifier, onButtonClick) {
//    Row(modifier = modifier.fillMaxWidth()) {
//
//        IconButton(
//            onClick = { onButtonClick("@gmail.com") },
//            modifier
//                .wrapContentSize()
//                .align(Alignment.CenterVertically)
//                .weight(.1f)
//        ) {
//            Icon(Icons.Filled.Clear, "content description")
//        }
//    }
//}