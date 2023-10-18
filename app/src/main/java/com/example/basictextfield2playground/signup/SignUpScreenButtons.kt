package com.example.basictextfield2playground.signup

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text2.BasicSecureTextField
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basictextfield2playground.R
import com.example.basictextfield2playground.ui.theme.textStyleBodyLarge
import com.example.basictextfield2playground.uicomponents.modifierBTFBorder

/**
 * Showcases state observation, viewmodel
 */
@Composable
@OptIn(ExperimentalFoundationApi::class)
@PreviewLightDark
fun SignUpButtonsScreen(
    modifier: Modifier = Modifier
) {

    val username = rememberTextFieldState("")

    SignUpScreenScaffold {
        Row(
            modifier = modifierBTFBorder
                .fillMaxWidth()
                .height(24.dp)
        ) {
            BasicTextField2(
                state = username,
                modifier = Modifier
                    .weight(.9f)
                    .align(Alignment.CenterVertically),
                textStyle = textStyleBodyLarge,
                lineLimits = TextFieldLineLimits.SingleLine,
            )
            IconButton(
                onClick = { username },
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(.1f)
                    .wrapContentSize()
            ) {
                Icon(Icons.Filled.Clear, "content description")
            }
        }


        Spacer(modifier = Modifier.height(4.dp))

        Row {
            IconButton(
                onClick = { username.edit { append("@gmail.com") } },
                modifier = Modifier
                    .border(1.dp, Color.Gray, shape = RoundedCornerShape(8.dp))
                    .align(Alignment.CenterVertically)
                    .weight(.1f)
                    .wrapContentSize()
                    .clickable { username.edit { append("@gmail.com") } }
            ) {
                Icon(painterResource(id = R.drawable.google_logo), "content description")
            }
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(
                onClick = { username.edit { append("@magicemail.com") } },
                modifier = Modifier
                    .border(1.dp, Color.Gray, shape = RoundedCornerShape(8.dp))
                    .align(Alignment.CenterVertically)
                    .weight(.1f)
                    .wrapContentSize()
            ) {
                Icon(painterResource(id = R.drawable.email_another), "content description")
            }
            Spacer(modifier = Modifier.width(8.dp))
            IconButton(
                onClick = { username.edit { append("@magicemail.com") } },
                modifier = Modifier
                    .border(1.dp, Color.Gray, shape = RoundedCornerShape(8.dp))
                    .align(Alignment.CenterVertically)

                    .weight(.1f)
                    .wrapContentSize()
            ) {
                Icon(painterResource(id = R.drawable.another), "content description")
            }

        }

    }
}
