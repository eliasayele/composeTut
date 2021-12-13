package com.example.composetut


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetut.ui.theme.ComposeTutTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
             Column(
                 modifier = Modifier
                     .background(Color.Green)
                     .fillMaxHeight(0.5f)
                     .fillMaxWidth()

                    // .padding(horizontal = 40.dp, vertical = 50.dp)
                    // .width(600.dp)
                    //  .requiredWidth(600.dp)
                     .border(5.dp, Color.Magenta)
                     .padding(5.dp)
                     .border(5.dp,Color.Blue)
                     .padding(5.dp)
                     .border(5.dp,Color.Black)
                     .padding(5.dp)




             ) {

              Text(text = "Hello",
                  modifier = Modifier.offset(0.dp,20.dp))
                 Spacer(modifier = Modifier.height(50.dp))
                 Text(text = "World!", modifier =
                 Modifier.clickable{

                 })
            }

        }
    }
}



@Composable
fun Greeting(name: String) {
    Text(text = "$name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTutTheme {
        Greeting("elias")
    }
}