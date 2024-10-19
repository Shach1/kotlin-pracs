package ru.mirea.prac5

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.mirea.prac5.databese.MainDatabase
import ru.mirea.prac5.entity.TodosEntity
import ru.mirea.prac5.model.TodosModel
import ru.mirea.prac5.services.TodosRetrofitApi

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Retrofit
        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitService = retrofit.create(TodosRetrofitApi::class.java)

        MainScope().launch {
            val response = retrofitService.getAllTodos()
            Log.d("RETROFIT", "Response received with code ${response.code()}")

            if (response.code() == 200)
            {
                Log.d("RETROFIT", "Response contains ${response.body()!!.todos.size} todos")
                val todosModel : TodosModel = response.body()!!
                runOnUiThread {
                    findViewById<TextView>(R.id.textView).text = todosModel.todos[6].toString()
                }
            }
            else Log.e("RETROFIT", "Error ${response.code()}")
        }

        val db = Room.databaseBuilder(
            applicationContext,
            MainDatabase::class.java, "test"
        ).build()

        val todoDao = db.todoDao()

        try {
            todoDao.insert(TodosEntity(0, "sdafsad", false, "1"))
            Log.d("ROOM", todoDao.getAll().toString())
        } catch (e: Exception) {
            Log.e("ROOM", "Error inserting todo", e)
        }


    }
}