package ru.mirea.prac5.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.mirea.prac5.entity.TodosEntity

@Dao
interface TodoDao
{
    @Insert
    fun insert(todo: TodosEntity)

    @Query("SELECT * FROM todos")
    fun getAll(): LiveData<List<TodosEntity>>
}