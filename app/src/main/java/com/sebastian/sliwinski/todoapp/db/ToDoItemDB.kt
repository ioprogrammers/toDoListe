package com.sebastian.sliwinski.todoapp.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ToDoItemDB(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val text: String
)