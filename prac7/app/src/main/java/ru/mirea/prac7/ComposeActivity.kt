package ru.mirea.prac7

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ru.mirea.prac7.ui.theme.Prac7Theme
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class ComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingPreview()
        }
    }
}



@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Light Mode")
@Composable
fun GreetingPreview() {

    var url by remember { mutableStateOf("https://random-image-pepebigotes.vercel.app/api/skeleton-random-image") }
    var fileName by remember { mutableStateOf("") }

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
                        .border(1.dp, Color.Gray) // Рамка вокруг текстового поля
                ) {
                    if (url.isEmpty()) {
                        Text(
                            text = "Введите ссылку", // Текст подсказки
                            color = Color.Gray, // Цвет подсказки
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                    // Само текстовое поле
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
                        .border(1.dp, Color.Gray) // Рамка вокруг текстового поля
                ) {
                    if (fileName.isEmpty()) {
                        Text(
                            text = "Введите название файла", // Текст подсказки
                            color = Color.Gray, // Цвет подсказки
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                    // Само текстовое поле
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
                    onClick = {},
                    modifier = Modifier
                        .padding(top = 80.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Text(text = "Сохранить")
                }
            }
        }
    }
}