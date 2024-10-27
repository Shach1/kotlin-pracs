package ru.mirea.prac5.inject

import android.content.Context
import androidx.room.Room
import dagger.hilt.android.qualifiers.ApplicationContext
import ru.mirea.prac5.databese.MainDatabase
import ru.mirea.prac5.entity.TodosEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatabaseHelper @Inject constructor(@ApplicationContext private val appContext: Context) {
    private val db = Room.databaseBuilder(
        appContext,
        MainDatabase::class.java,
        "test"
    ).build()
    private val todoDao = db.todoDao()

    suspend fun insertTodo (todo: TodosEntity) {todoDao.insert(todo)}
    suspend fun insertAllTodos (todos: List<TodosEntity>) {todoDao.insertAll(todos)}
    suspend fun getAllTodos () : List<TodosEntity> {return todoDao.getAll()}
    suspend fun deleteAllTodos () {todoDao.deleteAll()}
}