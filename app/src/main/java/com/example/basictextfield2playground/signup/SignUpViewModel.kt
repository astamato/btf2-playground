package com.example.basictextfield2playground.signup

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.foundation.text2.input.selectAll
import androidx.compose.foundation.text2.input.setTextAndSelectAll
import androidx.compose.foundation.text2.input.textAsFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn

@OptIn(ExperimentalCoroutinesApi::class, ExperimentalFoundationApi::class)
class SignUpViewModel : ViewModel() {

    private val signUpRepository = SignUpRepository()

    var username = TextFieldState("")
        private set

    // How to make this part of the rest of the ui state?

    val userNameHasError: StateFlow<Boolean> =
        username.textAsFlow()
            .mapLatest { signUpRepository.isUsernameAvailable(it.compositionInChars.toString()) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = false
            )

//    fun updateUsername(input: String) {
//
//    }

    fun clearField() {
        username.edit {
            replace(0, length, "")
        }
    }
}


