package com.sebastian.sliwinski.todoapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoItemDAO {
    @Insert
    suspend fun save(toDoItemDB: ToDoItemDB)
    @Query("select * from ToDoItemDB where id = :id limit 1")
    suspend fun get(id:Long) : ToDoItemDB
    @Query("select * from ToDoItemDB")
    fun getAll() : Flow<List<ToDoItemDB>>
}