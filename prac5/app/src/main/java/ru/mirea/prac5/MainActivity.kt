package ru.mirea.prac5

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.mirea.prac5.dao.TodoDao
import ru.mirea.prac5.databese.MainDatabase
import ru.mirea.prac5.databinding.ActivityMainBinding
import ru.mirea.prac5.entity.TodosEntity
import ru.mirea.prac5.services.TodosRetrofitApi

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var retrofitService: TodosRetrofitApi
    private lateinit var todoDao: TodoDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btGetAllTodos.setOnClickListener {
            loadAndSaveAllTodos()
        }

        binding.btGetTodoById.setOnClickListener {
            try {
                val id = binding.etId.text.toString().toInt()
                loadAndSaveTodoById(id.toString())
            }
            catch (e: Exception) {
                Log.e("MAIN", "Error ", e)
            }
        }

        binding.btDeleteAllTodos.setOnClickListener {
            deleteAllTodos()
        }

        binding.btToViewActivity.setOnClickListener{
            startActivity(Intent(this, ViewActivity::class.java))
        }


        // init Retrofit
        val retrofit : Retrofit = Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofitService = retrofit.create(TodosRetrofitApi::class.java)

        // init Database
        val db = Room.databaseBuilder(
            applicationContext,
            MainDatabase::class.java,
            "test"
        ).build()
        todoDao = db.todoDao()
    }

    private fun loadAndSaveAllTodos() {
        CoroutineScope(Dispatchers.IO).launch {

            //Получение запроса
            val response = retrofitService.getAllTodos()
            Log.d("RETROFIT", "Response received with code ${response.code()}")

            //Получение данных из запроса
            var todosEntity : List<TodosEntity> = emptyList()
            if (response.code() == 200)
            {
                Log.d("RETROFIT", "Response contains ${response.body()!!.todos.size} todos")
                /// Маппим объекты
                todosEntity = response.body()!!.todos.map {
                    TodosEntity(
                        id = it.id,
                        todo = it.todo,
                        completed = it.completed,
                        userId = it.userId
                    )
                }
            }
            else Log.e("RETROFIT", "Error ${response.code()}")

            //Сохранение данных в базу данных
            try {
                todoDao.deleteAll()
                todoDao.insertAll(todosEntity)
                Log.d("ROOM", "Table test contains ${todoDao.getAll()}")
                Toast.makeText(applicationContext, "Successful", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Log.e("ROOM", "Error inserting todo", e)
            }
        }
    }

    private fun loadAndSaveTodoById(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            //Получение запроса
            val response = retrofitService.getTodoById(id)
            Log.d("RETROFIT", "Response received with code ${response.code()}")

            //Получение данных из запроса
            var todosEntity : TodosEntity? = null
            if (response.code() == 200)
            {
                Log.d("RETROFIT", "Response contains ${response.body()} todo")
                // Маппим объект
                todosEntity = response.body()!!.let {
                    TodosEntity(
                        id = it.id,
                        todo = it.todo,
                        completed = it.completed,
                        userId = it.userId
                    )
                }
            }
            else Log.e("RETROFIT", "Error ${response.code()}")

            //Сохранение данных в базу данных
            try {
                todoDao.insert(todosEntity!!)
                Log.d("ROOM", "Table test contains ${todoDao.getAll()}")
                Toast.makeText(applicationContext, "Successful", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Log.e("ROOM", "Error inserting todo", e)
            }
        }
    }

    private fun deleteAllTodos() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                todoDao.deleteAll()
                Log.d("ROOM", "Table test contains ${todoDao.getAll()}")
                Toast.makeText(applicationContext, "Successful", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                Log.e("ROOM", "Error deleting todos", e)
            }
        }
    }
}