package com.example.basictextfield2playground.form

import android.text.InputFilter.AllCaps
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.InputTransformation
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.text2.input.allCaps
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardCapitalization.Companion.Characters
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import androidx.compose.ui.unit.dp
import com.example.basictextfield2playground.R
import com.example.basictextfield2playground.uicomponents.LabelText
import com.example.basictextfield2playground.uicomponents.modifierBTFBorder

/***
 * Showcases AllCapsTransformation for postcode
 * input transofrmation phone number
 *
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PersonalDetailsForm(modifier: Modifier = Modifier) {
    Column(modifier.padding(16.dp)) {
        LabelText(stringResource(id = R.string.post_code))

        val postCode = rememberTextFieldState(initialText = "")
        BasicTextField2(
            postCode,
            lineLimits = TextFieldLineLimits.SingleLine,
            modifier = modifierBTFBorder.fillMaxWidth(),
            // input transformation
            inputTransformation = InputTransformation.Companion.allCaps(Locale.current),
//            keyboardOptions = KeyboardOptions(capitalization = Characters)
        )
    }
}


@Composable
@PreviewLightDark
@PreviewScreenSizes
fun PersonalDetailsFormPreview() {
    PersonalDetailsForm()
}
