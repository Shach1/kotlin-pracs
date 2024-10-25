package ru.mirea.prac5.model

data class TodoModel(
    val id: Int,
    val todo: String,
    val completed: Boolean,
    val userId : String
)