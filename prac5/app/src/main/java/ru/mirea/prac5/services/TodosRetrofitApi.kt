package ru.mirea.prac5.services

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import ru.mirea.prac5.model.TodoModel
import ru.mirea.prac5.model.TodosModel

interface TodosRetrofitApi
{
    @GET("/todos/{id}")
    suspend fun getTodoById(@Path("id") id: String): Response<TodoModel>

    @GET("/todos")
    suspend fun getAllTodos(): Response<TodosModel>


}