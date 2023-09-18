package com.example.basictextfield2playground.form

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text2.BasicSecureTextField
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel


/**
 * Credit card number,expiration date input/output transformation
 * Showcases single line
 * Write your own input transformation -> transform input
 *
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CreditCardForm(modifier: Modifier = Modifier) {
    Text(text = "This is a form!")
}


@Preview
@Composable
fun CreditCardFormPreview() {
    
}
