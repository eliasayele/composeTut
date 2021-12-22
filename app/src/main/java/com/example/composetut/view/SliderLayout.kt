package com.example.composetut.view

import android.graphics.PorterDuff
import android.media.Rating
import android.widget.RatingBar
import android.widget.Space
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp

import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.compose.ui.viewinterop.AndroidView

import com.example.composetut.model.kidsList

import com.google.accompanist.pager.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield

import kotlin.math.absoluteValue


@ExperimentalPagerApi
@Composable
fun ViewPagerSlider(){
    val pagerState = rememberPagerState(
        initialPage =2,
        pageCount = kidsList.size
    )
    LaunchedEffect(Unit){
        while (true){
            yield()
            delay(2000)
            pagerState.animateScrollToPage(
                page = (pagerState.currentPage + 1) % (pagerState.pageCount),
                animationSpec = tween(600)
            )

        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier
            .height(50.dp)
            .fillMaxWidth()
            .background(color = Color.Cyan),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {
            Text(text = "View pager Slide",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)

        }
        Spacer(modifier = Modifier.height(30.dp))
        HorizontalPager(state = pagerState, modifier = Modifier
            .weight(1f)
            .padding(0.dp, 40.dp, 0.dp, 40.dp)) { page ->
            Card(modifier = Modifier
                .graphicsLayer {
                    val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue

                    lerp(
                        start = 0.85f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )
//                    .also {
//                        scaleX = scale
//                        scaleY = scale
//                    } 
                    alpha = lerp(
                        start = 0.5f,
                        stop = 1f,
                        fraction = 1f - pageOffset.coerceIn(0f, 1f)
                    )

                }
                .fillMaxWidth()
                .padding(25.dp, 0.dp, 25.dp, 0.dp),
                shape = RoundedCornerShape(20.dp)
            ){
            val newKids =  kidsList[page]
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.LightGray)
                        .align(Alignment.Center)
                ) {
                    Image(painter = painterResource(id = newKids.imageUri), contentDescription = "Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize())
                    Column(modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(15.dp)) {

                        Text(text = newKids.title,
                            style = MaterialTheme.typography.h5,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                         )

                        val retingBar = RatingBar(
                            LocalContext.current,
                            null,
                            com.example.composetut.R.attr.ratingBarStyleSmall
                        ).apply {

                            rating =  newKids.reting

                            progressDrawable.setColorFilter(
                                android.graphics.Color.parseColor("#FF0000"),
                                PorterDuff.Mode.SRC_ATOP
                            )

                        }
                        AndroidView(factory = {retingBar},
                            modifier = Modifier.padding(0.dp,8.dp,0.dp,0.dp)
                        )
                        Text(text = newKids.desc,
                            style = MaterialTheme.typography.body1,
                            color = Color.White,
                            fontWeight = FontWeight.Normal,
                        )

                    }
                }


            }

        }

        ///Horizontal dot indicator
        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier.align(Alignment.CenterHorizontally)
                .padding(16.dp)
        )
        
    }
}