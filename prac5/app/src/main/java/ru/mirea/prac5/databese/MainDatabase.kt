package ru.mirea.prac5.databese

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.mirea.prac5.dao.TodoDao
import ru.mirea.prac5.entity.TodosEntity

@Database(
    entities = [TodosEntity::class],
    version = 1
)
abstract class MainDatabase : RoomDatabase()
{
    abstract fun todoDao(): TodoDao
}