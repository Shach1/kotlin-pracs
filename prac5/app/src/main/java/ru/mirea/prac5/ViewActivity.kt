package ru.mirea.prac5

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.mirea.prac5.adapter.TodosAdapter
import ru.mirea.prac5.dao.TodoDao
import ru.mirea.prac5.databese.MainDatabase
import ru.mirea.prac5.databinding.ActivityViewBinding
import ru.mirea.prac5.entity.TodosEntity
import ru.mirea.prac5.inject.DatabaseHelper
import javax.inject.Inject

@AndroidEntryPoint
class ViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewBinding
    @Inject lateinit var dbHelper: DatabaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        Log.d("HILT", dbHelper.toString())


        CoroutineScope(Dispatchers.IO).launch {
            val todos: List<TodosEntity> = dbHelper.getAllTodos()

            lifecycleScope.launch(Dispatchers.Main) {
                val adapter = TodosAdapter(todos)
                binding.rvTodos.layoutManager = LinearLayoutManager(this@ViewActivity)
                binding.rvTodos.adapter = adapter
            }
        }
    }
}