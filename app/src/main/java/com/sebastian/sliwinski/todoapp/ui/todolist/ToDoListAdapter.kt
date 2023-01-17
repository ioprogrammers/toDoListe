package com.sebastian.sliwinski.todoapp.ui.todolist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.sebastian.sliwinski.todoapp.R
import com.sebastian.sliwinski.todoapp.databinding.TodoListItemBinding
import com.sebastian.sliwinski.todoapp.db.ToDoItemDB
import java.util.*

class ToDoListAdapter () : ListAdapter<ToDoItemUI, ViewHolder>(object : DiffUtil.ItemCallback<ToDoItemUI>(){
    override fun areItemsTheSame(oldItem: ToDoItemUI, newItem: ToDoItemUI): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ToDoItemUI, newItem: ToDoItemUI): Boolean {
        return oldItem.text == newItem.text
    }

}) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TodoListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvTodoItem.text = getItem(position).text
    }


}

class ViewHolder (val binding: TodoListItemBinding) : RecyclerView.ViewHolder(binding.root)