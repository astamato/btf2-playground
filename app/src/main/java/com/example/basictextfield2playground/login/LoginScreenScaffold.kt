package com.example.basictextfield2playground.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.basictextfield2playground.R
import com.example.basictextfield2playground.uicomponents.MainButton

@Composable
@PreviewLightDark
fun LoginScreenScaffold(
    modifier: Modifier = Modifier,
    onLoginSuccess: () -> Unit = {},
    textFieldSlot: @Composable ColumnScope.() -> Unit = {},
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            stringResource(id = R.string.login_title),
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(8.dp))

        textFieldSlot()

        Spacer(modifier = Modifier.height(8.dp))

        MainButton(
            onLoginSuccess,
            modifier = Modifier.align(CenterHorizontally),
            stringResource(id = R.string.login_button)
        )
    }
}
