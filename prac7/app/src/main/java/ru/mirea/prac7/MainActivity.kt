package ru.mirea.prac7

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import ru.mirea.prac7.databinding.ActivityMainBinding
import java.io.FileOutputStream


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btSave.setOnClickListener { downloadAndSaveFile() }
    }

    private suspend fun downloadImage(url: String) : Bitmap? = withContext(Dispatchers.IO) {
        try {
            val client = OkHttpClient()
            val request = Request.Builder().url(url).build()
            val response = client.newCall(request).execute()
            val inputStream = response.body?.byteStream()
            BitmapFactory.decodeStream(inputStream)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    private suspend fun saveImage(image: Bitmap, filename: String) = withContext(Dispatchers.IO) {
        try {
            val fos: FileOutputStream = openFileOutput(filename, MODE_PRIVATE)
            image.compress(Bitmap.CompressFormat.PNG, 100, fos)
            fos.flush()
            fos.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun downloadAndSaveFile(){
        val url : String = binding.etUrl.text.toString()
        val filename : String = binding.etFileName.text.toString()
        if (url.isEmpty() || filename.isEmpty()) return

        CoroutineScope(Dispatchers.Main).launch {
            val image : Bitmap? = downloadImage(url)
            image.let {
                if (it != null) {
                    Log.d("downloadImage", "Image downloaded")
                    saveImage(it, "$filename.png")
                    Toast.makeText(applicationContext, "Image saved", Toast.LENGTH_SHORT).show()

                    runOnUiThread {
                        binding.imageView.setImageBitmap(it)
                    }
                }
                else Log.e("downloadImage", "Error downloading image")
            }
        }
    }
}