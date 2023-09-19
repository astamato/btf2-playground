package com.example.basictextfield2playground.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.basictextfield2playground.R

val textStyleDefault = TextStyle(
    fontFamily = FontFamily(
        Font(R.font.googlesans_regular),
        Font(R.font.googlesans_bold, FontWeight.Bold),
        Font(R.font.googlesans_italic, FontWeight.Normal, FontStyle.Italic),
        Font(R.font.googlesans_bolditalic, FontWeight.Bold, FontStyle.Italic),
        Font(R.font.googlesans_medium, FontWeight.Medium),
        Font(R.font.googlesans_mediumitalic, FontWeight.Medium, FontStyle.Italic),
    )
)

val textStyleGoogleSansTextDefault = TextStyle(
    fontFamily = FontFamily(
        Font(R.font.googlesanstext_regular),
        Font(R.font.googlesanstext_bold, FontWeight.Bold),
        Font(R.font.googlesanstext_italic, FontWeight.Normal, FontStyle.Italic),
        Font(R.font.googlesanstext_bolditalic, FontWeight.Bold, FontStyle.Italic),
        Font(R.font.googlesanstext_medium, FontWeight.Medium),
        Font(R.font.googlesanstext_mediumitalic, FontWeight.Medium, FontStyle.Italic),
    )
)

val textStyleBodyLarge = textStyleDefault.copy(
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp,
    lineHeight = 24.sp,
    letterSpacing = 0.5.sp
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = textStyleBodyLarge
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
