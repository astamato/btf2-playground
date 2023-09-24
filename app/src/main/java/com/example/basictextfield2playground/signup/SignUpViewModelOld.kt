package com.example.basictextfield2playground.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn

@OptIn(ExperimentalCoroutinesApi::class)
class SignUpViewModelOld() : ViewModel() {

private val signUpRepository = SignUpRepository()

    var username by mutableStateOf("")
        private set

    val userNameHasError: StateFlow<Boolean> =
        snapshotFlow { username }
            .mapLatest { signUpRepository.isUsernameAvailable(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = false
            )

    fun updateUsername(input: String) {
        username = input
    }
}
