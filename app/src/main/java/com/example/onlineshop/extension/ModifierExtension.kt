package com.example.onlineshop.extension

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


fun Modifier.size(size: Int): Modifier = this.size(size.dp)
fun Modifier.size(width: Int, height: Int): Modifier = this.size(width.dp, height.dp)
fun Modifier.width(width: Int): Modifier = this.width(width.dp)
fun Modifier.height(height: Int): Modifier = this.height(height.dp)

fun Modifier.padding(horizontal: Int, vertical: Int): Modifier =
    this.padding(horizontal.dp, vertical.dp)
fun Modifier.padding(start: Int, end: Int, top: Int, bottom: Int): Modifier = this.padding(
    start = start.dp, end = end.dp, top = top.dp, bottom = bottom.dp
)
fun Modifier.padding(all: Int): Modifier = this.padding(all.dp)
