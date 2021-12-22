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
    KidsData("Love Her exression",4.5f,"All the children in the word are cute and innocient", R.drawable.ic_play),
    KidsData("Remembering Childohod",4.5f,"All the children in the word are cute and innocient", R.drawable.ic_play),
    KidsData("Girls with the bautiful smil",4.5f,"All the children in the word are cute and innocient", R.drawable.ic_play),
    KidsData("Bath Time",4.5f,"All the children in the word are cute and innocient", R.drawable.ic_play),
    KidsData("Beginning Life",4.5f,"All the children in the word are cute and innocient", R.drawable.ic_play),
    KidsData("Sleep Time",4.5f,"All the children in the word are cute and innocient", R.drawable.ic_play),
)