package com.example.composetut


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import com.example.composetut.ui.theme.ComposeTutTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fontFamily = FontFamily(
            Font(R.font.lexenddeca_thin, FontWeight.Thin),
            Font(R.font.lexenddeca_light, FontWeight.Light),
        )
        //painter for taking resource
        //strings for description
        setContent {
            val scaffoldState = rememberScaffoldState()
           var textFiledState by remember {
               mutableStateOf("")
           }
            val  scope = rememberCoroutineScope()

           Scaffold(modifier = Modifier.fillMaxSize(),
           scaffoldState = scaffoldState

               ) {
               Column(
                   horizontalAlignment = Alignment.CenterHorizontally,
                   verticalArrangement = Arrangement.Center,
                   modifier = Modifier
                       .fillMaxSize()
                       .padding(horizontal = 38.dp)
               
                   ) {
                   TextField(value = textFiledState, label = {
                       Text(text = "Enter Your Name")
                   }, onValueChange = {
                       textFiledState = it
                   },
                   singleLine = true,
                   modifier = Modifier.fillMaxWidth())
                   Spacer(modifier = Modifier.height(16.dp))
                   Button(onClick = {
                       scope.launch {
                           scaffoldState.snackbarHostState.showSnackbar("Hello $textFiledState")

                       }
                   }) {
                       Text(text = "please gread me")
                   }

               }
               Text(text = "Hello Philip")
           }
        }
    }
}







@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTutTheme {
        Text("Jetpack")
    }
}