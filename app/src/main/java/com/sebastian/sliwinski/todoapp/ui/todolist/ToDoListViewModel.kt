package com.sebastian.sliwinski.todoapp.ui.todolist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.sebastian.sliwinski.todoapp.db.ToDoItemDAO
import com.sebastian.sliwinski.todoapp.db.ToDoItemDB
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoListViewModel @Inject constructor(private val toDoItemDAO: ToDoItemDAO) : ViewModel() {

    private val _nav = Channel<NavDirections>()
    val nav = _nav.receiveAsFlow()
    private val _items = MutableLiveData<List<ToDoItemUI>>()
    val items : LiveData<List<ToDoItemUI>> =  _items


    init {
        viewModelScope.launch {
            toDoItemDAO.getAll()
                .map {
                    it.map{
                        ToDoItemUI(it.id, it.text)
                    }
                }
                .collect{
                    _items.value = it
                }
        }
    }

    fun addNewPressed() {
        _nav.trySend(ToDoListFragmentDirections.actionToDoListFragmentToEditFragment(0L))
    }

}