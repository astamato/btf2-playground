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
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn

@OptIn(ExperimentalCoroutinesApi::class)
class SignUpViewModelOld() : ViewModel() {

    private val signUpRepository = SignUpRepository()

    private var username by mutableStateOf("")

    val userNameHasError: StateFlow<Boolean> =
        snapshotFlow { username }
            .mapLatest { signUpRepository.isUsernameAvailable(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = false
            )

//    fun setUsername(input: String) {
//        username = input
//    }

    val combinedStateFlow: StateFlow<SignUpState> = combine(
        snapshotFlow { username }.mapLatest { signUpRepository.isUsernameAvailable(it) },
        signUpRepository.isValid(username)
    ) { value1, value2 ->
        // Create a new CombinedState object with the combined data
        SignUpState(value1 && value2)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = SignUpState(false)
    )
}

data class SignUpState(val hasError: Boolean)
