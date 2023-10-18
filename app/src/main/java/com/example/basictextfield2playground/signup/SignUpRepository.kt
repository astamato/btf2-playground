package com.example.basictextfield2playground.signup

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class SignUpRepository {
    fun isUsernameAvailable(it: String) = listUsed.contains(it)

    fun isValid(it: String): Flow<Boolean> = flowOf(true)

    companion object {
        val listUsed = listOf("username", "ale")
    }
}
