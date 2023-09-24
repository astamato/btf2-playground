package com.example.basictextfield2playground.signup

class SignUpRepository {
    fun isUsernameAvailable(it: String) = listUsed.contains(it)

    companion object {
        val listUsed = listOf("username", "ale")
    }
}
