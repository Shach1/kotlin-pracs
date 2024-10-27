package ru.mirea.prac5.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.mirea.prac5.databinding.TodoEntityItemBinding
import ru.mirea.prac5.entity.TodosEntity

class TodosAdapter(private val todos: List<TodosEntity>) : RecyclerView.Adapter<TodosAdapter.TodosViewHolder>() {
    class TodosViewHolder(private val binding: TodoEntityItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(todo: TodosEntity) {
            binding.tvUserId.text = "User ID: ${todo.userId}"
            binding.tvTodo.text = todo.todo
            binding.cbCompleted.isChecked = todo.completed
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodosViewHolder {
        val binding = TodoEntityItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodosViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodosViewHolder, position: Int) {
        val todo = todos[position]
        holder.bind(todo)
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}