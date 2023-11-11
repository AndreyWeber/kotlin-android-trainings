package com.example.tapcounter.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel(startingCount: Int) : ViewModel() {
    val count = mutableStateOf(startingCount)

    fun incrementCounter() {
        count.value += 1
    }
}