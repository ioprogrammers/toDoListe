package com.sebastian.sliwinski.todoapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = arrayOf(ToDoItemDB::class),version = 1)
abstract class ToDoItemsDataBase : RoomDatabase() {
    abstract fun toDoItemDao() : ToDoItemDAO
}