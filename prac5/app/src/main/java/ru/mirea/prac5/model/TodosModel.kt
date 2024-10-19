package ru.mirea.prac5.model

data class TodosModel(
    val todos : List<TodoModel>,
    val total : Int,
    val skip : Int,
    val limit : Int
)