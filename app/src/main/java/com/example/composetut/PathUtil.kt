package com.example.composetut

import androidx.compose.ui.geometry.Offset

import kotlin.math.abs
import androidx.compose.ui.graphics.Path
fun Path.standardQuadFromTo(from: Offset, to: Offset) {
        quadraticBezierTo(
            from.x,
            from.y,
            abs(from.x + to.x) / 2f,
            abs(from.y + to.y) / 2f
        )
    }