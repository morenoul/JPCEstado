package com.example.jpcestado.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Task(var id: Int, var title: String, var description: String, initialChecked:Boolean = false) {

    var isDone by mutableStateOf(initialChecked)

}