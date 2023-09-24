package com.example.basictextfield2playground.login

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.basictextfield2playground.R

@Composable
fun LoginButton(onLoginSuccess: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onLoginSuccess, modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        Text(stringResource(id = R.string.login_button))
    }
}
