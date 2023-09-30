package com.example.basictextfield2playground.form

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.InputTransformation
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.text2.input.maxLengthInChars
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.foundation.text2.input.then
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.basictextfield2playground.R
import com.example.basictextfield2playground.uicomponents.LabelText
import com.example.basictextfield2playground.uicomponents.modifierBTFBorder


/**
 * Credit card number,expiration date input/output transformation
 * Showcases single line
 * Write your own input transformation -> transform input
 *
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CreditCardForm(modifier: Modifier = Modifier) {
    Column(modifier.padding(16.dp)) {

        LabelText(stringResource(id = R.string.credit_card_details))

        val creditCardNumber = rememberTextFieldState(initialText = "")
        BasicTextField2(
            creditCardNumber,
            lineLimits = TextFieldLineLimits.SingleLine,
            modifier = modifierBTFBorder.fillMaxWidth(),
            inputTransformation = OnlyDigitsTransformation
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            val expirationDate = rememberTextFieldState(initialText = "")
            BasicTextField2(
                expirationDate,
                lineLimits = TextFieldLineLimits.SingleLine,
                modifier = modifierBTFBorder.weight(.5f)
            )

            Spacer(modifier = Modifier.width(8.dp))

            val cvv = rememberTextFieldState(initialText = "")
            BasicTextField2(
                cvv,
                lineLimits = TextFieldLineLimits.SingleLine,
                modifier = modifierBTFBorder.weight(.5f),
                inputTransformation = OnlyDigitsTransformation.then(
                    InputTransformation.maxLengthInChars(
                        3
                    )
                )
            )
        }
    }
}


@PreviewLightDark
@Composable
fun CreditCardFormPreview() {
    CreditCardForm()
}
