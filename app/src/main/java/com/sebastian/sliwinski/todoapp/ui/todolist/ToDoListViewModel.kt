package com.sebastian.sliwinski.todoapp.ui.todolist

import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

class ToDoListViewModel : ViewModel() {

    private val _nav = Channel<NavDirections>()
    val nav = _nav.receiveAsFlow()

    fun addNewPressed() {
        _nav.trySend()
    }

}