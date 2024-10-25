package ru.mirea.prac5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.mirea.prac5.dao.TodoDao
import ru.mirea.prac5.databese.MainDatabase
import ru.mirea.prac5.databinding.ActivityViewBinding
import ru.mirea.prac5.entity.TodosEntity

class ViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewBinding
    private lateinit var todoDao: TodoDao


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // init Database
        val db = Room.databaseBuilder(
            applicationContext,
            MainDatabase::class.java,
            "test"
        ).build()
        todoDao = db.todoDao()

        CoroutineScope(Dispatchers.IO).launch {
            val todos: List<TodosEntity> = todoDao.getAll()

            val adapter = TodosAdapter(todos)
            binding.rvTodos.layoutManager = LinearLayoutManager(this@ViewActivity)
            binding.rvTodos.adapter = adapter
        }
    }
}