package ru.mirea.prac5

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.mirea.prac5.dao.TodoDao
import ru.mirea.prac5.entity.TodosEntity

class TodosRepository(private val todoDao: TodoDao)
{
    val allTodos : LiveData<List<TodosEntity>> = todoDao.getAll()

    suspend fun insert(todo: TodosEntity)
    {
        todoDao.insert(todo)
    }

    suspend fun getAll(): LiveData<List<TodosEntity>>
    {
        return todoDao.getAll()
    }
}