package com.example.abc

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.abc.ui.theme.AbcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AbcTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun Greeting(name: String) {
    for (i in 0..19) {

    }
    val context = LocalContext.current
    var mper = MediaPlayer()

    var pictures= arrayListOf(
        R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5)
    var contents= arrayListOf(
        "Pura Tanah Lot","Kelingking Beach","Gebongan","Tari Kecak","Rice Terraces")

        LazyColumn(modifier=Modifier.fillMaxWidth()) {
            item { Text(text = "Different kinds of animal") }
            item {    Button(onClick = {
                mper.reset()
                context.startActivity(Intent(context, VideoActivity::class.java))

            }) {
                Text(text = "video")
            }
            }
            items (50){index->
                Column(modifier=Modifier.fillParentMaxWidth()) {
                    Text(text = contents[index%5])
                    Image(painter = painterResource(id = pictures[index%5]), contentDescription = "animals")
                }

            }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AbcTheme {
        Greeting("Android")
    }
}