package ru.mirea.prac5

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d("App", "Entry Point")
    }
}

//TODO: Перенести приложение на MVVM архитектуру чтобы при переходе на ViewActivity данные загружались из ViewModel, а не из DatabaseHelper
