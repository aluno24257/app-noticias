package com.example.noticias

data class MyData(
    val author: String,
    val categories: String,
    val content: String,
    val description: String,
    val enclosure: EnclosureX,
    val guid: String,
    val link: String,
    val pubDate: String,
    val title: String
)