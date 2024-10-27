package ru.mirea.prac5.inject

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.mirea.prac5.services.TodosRetrofitApi
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RetrofitService @Inject constructor() {
    private val retrofit : Retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val service = retrofit.create(TodosRetrofitApi::class.java)

    suspend fun getAllTodos() = service.getAllTodos()
    suspend fun getTodoById(id: String) = service.getTodoById(id)
}