package ru.mirea.prac7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.mirea.prac7.databinding.ActivityMainBinding
import java.io.File
import java.io.FileOutputStream


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btSave.setOnClickListener {
            val url = binding.etUrl.text.toString()
            val fileName = binding.etFileName.text.toString()
            if(url.isNotEmpty() and fileName.isNotEmpty()) downloadAndSetImage(url, fileName)
        }
    }

    private fun downloadAndSetImage(url: String, fileName: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = ImageLoader().getImage(url)

            if (response.isSuccessful) {
                response.body?.let { body ->
                    val file = File(filesDir, "${fileName}.jpg")
                    val outputStream = FileOutputStream(file)
                    outputStream.use { output -> output.write(body.bytes()) }

                    withContext(Dispatchers.Main) {
                        binding.imageView.setImageURI(file.toUri())
                    }
                }
            }
        }
    }
}