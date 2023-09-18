package com.example.basictextfield2playground.form

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/***
 * Showcases AllCapsTransformation for postcode
 *
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PersonalDetailsForm(modifier: Modifier = Modifier) {
    Text(text = "This is a form!")
}


@Preview
@Composable
fun PersonalDetailsFormPreview() {

}

