package ru.mirea.prac4

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ru.mirea.prac4.databinding.ActivityGalleryBinding
import java.io.File

class GalleryActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityGalleryBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        try {
            val photosDir = File(baseContext.filesDir, "photos")
            if (!photosDir.exists()) {
                photosDir.mkdir()
            }
            val dateFile = File(photosDir, "date.txt")
            if (!dateFile.exists()) {
                dateFile.createNewFile()
                Toast.makeText(this, "Файла с данными не было. Файл создан", Toast.LENGTH_SHORT).show()
                return
            }
            else{
                //считай данные из файла в массив строк
                val dataList = dateFile.readLines().toMutableList()
                if (dataList.isEmpty()) {
                    Toast.makeText(this, "Данных нет", Toast.LENGTH_SHORT).show()
                    return
                }
                val recyclerView = viewBinding.recyclerView
                val adapter = DataAdapter(dataList)
                recyclerView.adapter = adapter
                recyclerView.layoutManager = LinearLayoutManager(this)
            }


        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}