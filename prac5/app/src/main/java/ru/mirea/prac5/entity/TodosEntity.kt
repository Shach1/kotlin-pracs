package ru.mirea.prac5.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todos")
data class TodosEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "todo")
    val todo: String,

    @ColumnInfo(name = "completed")
    val completed: Boolean,

    @ColumnInfo(name = "userId")
    val userId : String
)