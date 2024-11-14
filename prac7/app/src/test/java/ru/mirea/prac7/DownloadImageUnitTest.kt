package ru.mirea.prac7

import okhttp3.OkHttpClient
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class DownloadImageUnitTest {
    private val client = OkHttpClient()

    @Test
    fun testResponseCodeIs200() {
        val url = "https://random-image-pepebigotes.vercel.app/api/skeleton-random-image"
        val response = ImageLoader().getImage(url)
        assertEquals(200, response.code)
    }

    @Test
    fun testResponseBodyIsNotEmpty() {
        val url = "https://random-image-pepebigotes.vercel.app/api/skeleton-random-image"
        val response = ImageLoader().getImage(url)
        assertNotNull("Response body is null", response.body)
    }
}