package ru.mirea.prac5.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.mirea.prac5.entity.TodosEntity

@Dao
interface TodoDao{
    @Insert
    suspend fun insert(todo: TodosEntity)

    @Insert
    suspend fun insertAll(todos: List<TodosEntity>)

    @Query("SELECT * FROM todos")
    suspend fun getAll(): List<TodosEntity>

    @Query("DELETE FROM todos")
    suspend fun deleteAll()
}