package com.example.basictextfield2playground.crazy

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.basictextfield2playground.uicomponents.modifierBTFBorder
import java.util.Locale

//  https://android-review.googlesource.com/c/platform/frameworks/support/+/2667326
/**
 * Tested async
 * In BTF2 the text is already updated
 */
@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun AlternativeConstructor(asyncTestViewModel: AsyncTestViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {

    Column {

        var username by remember { mutableStateOf("") }

        val state: String by asyncTestViewModel.username.collectAsStateWithLifecycle()

        BasicTextField2(
            modifier = modifierBTFBorder,
            value = state,
            onValueChange = {
                // this is ignored if BTF2 is in focus

                val a = it.uppercase(Locale.getDefault()) + "000"
                asyncTestViewModel.asyncOperation(a)
            }
        )

//        var btwWithAsyncError by remember { mutableStateOf("") }

//        BasicTextField(
//            modifier = modifierBTFBorder,
//            value = state,
//            onValueChange = {
//                asyncTestViewModel.asyncOperation(it)
//            }
//        )


        val btfCompare = rememberTextFieldState()
        BasicTextField2(
            modifier = modifierBTFBorder,
            state = btfCompare,
        )
    }
}
