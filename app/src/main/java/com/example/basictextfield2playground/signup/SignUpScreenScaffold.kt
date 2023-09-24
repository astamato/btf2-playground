package com.example.basictextfield2playground.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basictextfield2playground.R
import com.example.basictextfield2playground.login.TermsAndConditionsLabel
import com.example.basictextfield2playground.uicomponents.MainButton

/**
 * Showcases state observation, viewmodel
 */
@Composable
@Preview(showBackground = true)
fun SignUpScreenScaffold(
    modifier: Modifier = Modifier,
    textFieldSlot: @Composable ColumnScope.() -> Unit = {},
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            stringResource(id = R.string.sign_up_title),
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.titleMedium
        )
        textFieldSlot()
        TermsAndConditionsLabel()
        MainButton(
            {},
            modifier = Modifier.align(Alignment.CenterHorizontally),
            stringResource(id = R.string.sign_up_button)
        )
    }
}
