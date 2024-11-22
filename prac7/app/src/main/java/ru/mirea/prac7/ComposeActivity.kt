package ru.mirea.prac7

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.mirea.prac7.ui.theme.Prac7Theme
import java.io.File
import java.io.FileOutputStream


class ComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppLayout()
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun AppLayout() {

    var url by remember { mutableStateOf("https://random-image-pepebigotes.vercel.app/api/skeleton-random-image") }
    var fileName by remember { mutableStateOf("") }
    var imageBitmap by remember { mutableStateOf<Bitmap?>(null) }
    val context = LocalContext.current

    Prac7Theme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                //.background(Color.Yellow)
            ) {
                Box(
                    modifier = Modifier
                        .padding(top = 60.dp)
                        .width(300.dp)
                        .align(Alignment.CenterHorizontally)
                        .border(1.dp, Color.Gray)
                ) {
                    if (url.isEmpty()) {
                        Text(
                            text = "Введите ссылку",
                            color = Color.Gray,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                    BasicTextField(
                        value = url,
                        onValueChange = {url = it },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontSize = 18.sp
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .width(300.dp)
                        .align(Alignment.CenterHorizontally)
                        .border(1.dp, Color.Gray)
                ) {
                    if (fileName.isEmpty()) {
                        Text(
                            text = "Введите название файла",
                            color = Color.Gray,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                    BasicTextField(
                        value = fileName,
                        onValueChange = {fileName = it },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        textStyle = TextStyle(
                            color = Color.Black,
                            fontSize = 18.sp
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(30.dp)
                    )
                }
                Button(
                    onClick = {
                        if (url.isEmpty() || fileName.isEmpty()) return@Button
                        CoroutineScope(Dispatchers.IO).launch{
                            imageBitmap = downloadImageAndSetBitmap(context, url, fileName)
                        }
                    },
                    modifier = Modifier
                        .padding(top = 80.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "Сохранить")
                }
                if (imageBitmap != null){
                    Image(
                        bitmap = imageBitmap!!.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(top = 200.dp)
                            .size(318.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }
}

private fun downloadImageAndSetBitmap(context: Context, url: String, fileName: String) : Bitmap? {
    val response = ImageLoader().getImage(url)

    if (response.isSuccessful) {
        val file = File(context.filesDir, "${fileName}.jpg")
        val outputStream = FileOutputStream(file)
        outputStream.use { output -> output.write(response.body?.bytes()) }

        return loadBitmapFromUri(context, file.toUri())
    }
    return null
}

fun loadBitmapFromUri(context: Context, uri: Uri): Bitmap? {
    return try {
        // Открываем InputStream из Uri и декодируем его в Bitmap
        context.contentResolver.openInputStream(uri).use { inputStream ->
            BitmapFactory.decodeStream(inputStream)
        }
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}