package com.example.basictextfield2playground.email

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.runtime.Composable

/**
 * Showcases a very long text, with styles
 * Showcases multiline
 * Showcase search by keyword with hoisted scroll state
 * Showcase TextField buffer?
 *
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TextBoxForm() {

    val textBox = rememberTextFieldState(initialText = "")



    
}