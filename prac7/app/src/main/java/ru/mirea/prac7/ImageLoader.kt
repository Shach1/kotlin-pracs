package ru.mirea.prac7

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response


class ImageLoader {
    private val client = OkHttpClient()

    fun getImage(url: String): Response {
        val request = Request.Builder().url(url).build()
        val response = client.newCall(request).execute()
        return response
    }
}