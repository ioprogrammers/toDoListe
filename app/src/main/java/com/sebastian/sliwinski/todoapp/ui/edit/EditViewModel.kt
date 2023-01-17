package com.sebastian.sliwinski.todoapp.ui.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sebastian.sliwinski.todoapp.db.ToDoItemDAO
import com.sebastian.sliwinski.todoapp.db.ToDoItemDB
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(
    private val toDoItemDAO: ToDoItemDAO
) : ViewModel() {

    fun saveButtonPressed(text: String) {
        viewModelScope.launch {
            toDoItemDAO.save(ToDoItemDB(0L, text))
        }
    }

    fun setId(id: Long) {
        if (id > 0) {
            viewModelScope.launch {
                val item = toDoItemDAO.get(id)
            }
        }
    }


}