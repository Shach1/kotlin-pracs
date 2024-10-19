package ru.mirea.prac5.model

data class TodoModel(
    val id: String,
    val todo: String,
    val completed: Boolean,
    val userId : String
)