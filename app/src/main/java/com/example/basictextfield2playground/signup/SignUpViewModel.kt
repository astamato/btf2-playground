package com.example.basictextfield2playground.signup

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.foundation.text2.input.clearText
import androidx.compose.foundation.text2.input.forEachTextValue
import androidx.compose.foundation.text2.input.selectAll
import androidx.compose.foundation.text2.input.textAsFlow
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn

@OptIn(ExperimentalCoroutinesApi::class, ExperimentalFoundationApi::class)
class SignUpViewModel : ViewModel() {

    private val signUpRepository = SignUpRepository()

    var username = TextFieldState("")
        private set

    // How to make this part of the rest of the ui state?

    val duserNameHasError by derivedStateOf { userNameHasError }
    var userNameHasError by mutableStateOf(false)
    suspend fun validateUsername() {
        username.forEachTextValue {
            userNameHasError = signUpRepository.isUsernameAvailable(it.toString())
        }
    }


    val userNameHasErrorWithSelect: StateFlow<Boolean> =
        username.textAsFlow()
            .debounce(500)
            .mapLatest {
                val textContent = it.toString()
                val hasError =
                    signUpRepository.isUsernameAvailable(textContent)
                if (hasError) highlightSelect()
                return@mapLatest hasError
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = false
            )

    fun updateUsername(input: String) {
        username.clearText()
        /**
         * forEachTextValue is intended to be a more simple and discoverable
         * way to observe state changes from outside of Composables than requiring
         * the knowledge and use of low-level Snapshot APIs.
         *
         */
//        username.forEachTextValue {
//
//
//        }


    }

    fun clearField() {
//        username.edit {
//            replace(0, length, "")
//        }
        username.clearText()
    }

    fun highlightSelect() {
        username.edit { selectAll() }
    }
}

