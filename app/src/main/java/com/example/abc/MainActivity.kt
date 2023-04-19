package com.example.abc

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    var animals= arrayListOf(
        R.drawable.koala,R.drawable.boar,R.drawable.chick,R.drawable.dog,R.drawable.chimp,R.drawable.elephant,
        R.drawable.horse,R.drawable.parrot,R.drawable.racoon,R.drawable.sloth)
    var contents= arrayListOf(
        "koala","boar","chick","dog","chimp","elephant","horse","parrot","racoon","sloth")

        LazyRow(modifier=Modifier.fillMaxWidth()) {
            item { Text(text = "Different kinds of animal") }
            items (50){index->
                Column(modifier=Modifier.fillParentMaxWidth()) {
                    Text(text = contents[index%10])
                    Image(painter = painterResource(id = animals[index%10]), contentDescription = "animals")
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