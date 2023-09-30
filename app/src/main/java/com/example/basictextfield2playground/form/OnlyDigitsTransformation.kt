package com.example.basictextfield2playground.form

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.input.InputTransformation
import androidx.compose.foundation.text2.input.TextFieldBuffer
import androidx.compose.foundation.text2.input.TextFieldCharSequence
import androidx.compose.ui.text.input.KeyboardType
import androidx.core.text.isDigitsOnly

@OptIn(ExperimentalFoundationApi::class)
object OnlyDigitsTransformation : InputTransformation {
    override val keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword)

    override fun transformInput(
        originalValue: TextFieldCharSequence,
        valueWithChanges: TextFieldBuffer
    ) {
        if (!valueWithChanges.asCharSequence().isDigitsOnly()) {
            valueWithChanges.revertAllChanges()
        }
    }
}

