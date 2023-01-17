package com.sebastian.sliwinski.todoapp.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideToDoItemDataBase(@ApplicationContext context: Context): ToDoItemsDataBase {
        return Room.databaseBuilder(
            context,
            ToDoItemsDataBase::class.java,
            "ToDoItemsDataBase"
        ).build()
    }

    @Provides
    @Singleton
    fun provideToDoItemDao(toDoItemsDataBase: ToDoItemsDataBase): ToDoItemDAO {
        return toDoItemsDataBase.toDoItemDao()
    }
}