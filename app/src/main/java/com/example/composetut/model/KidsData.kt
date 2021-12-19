package com.example.composetut.model

import com.example.composetut.R

class KidsData (
    val title:String,
    val reting:Float,
    val desc:String,
    val imageUri:Int
    )


//prepare the date to display
val kidsList  = listOf(
    KidsData("Love Her exression",4.5f,"All the children in the word are cute and innocient", R.drawable.image_4),
    KidsData("Remembering Childohod",4.5f,"All the children in the word are cute and innocient", R.drawable.image_1),
    KidsData("Girls with the bautiful smil",4.5f,"All the children in the word are cute and innocient", R.drawable.image_3),
    KidsData("Bath Time",4.5f,"All the children in the word are cute and innocient", R.drawable.image_2),
    KidsData("Beginning Life",4.5f,"All the children in the word are cute and innocient", R.drawable.image_5),
    KidsData("Sleep Time",4.5f,"All the children in the word are cute and innocient", R.drawable.image_6),
)