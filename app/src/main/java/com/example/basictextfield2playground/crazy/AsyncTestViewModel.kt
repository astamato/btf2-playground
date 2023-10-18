package com.example.basictextfield2playground.crazy

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Locale

class AsyncTestViewModel : ViewModel() {

    private val _username = MutableStateFlow("")
    val username = _username.asStateFlow()

    fun asyncOperation(input: String) {
        viewModelScope.launch {
            // async operation
            delay(500L)
            Log.w("TEST", "Logs async operation")

            val b = (input + "242").lowercase(Locale.getDefault())
            _username.value = b
        }
    }
}
