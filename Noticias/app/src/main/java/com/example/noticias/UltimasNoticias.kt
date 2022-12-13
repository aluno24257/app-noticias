package com.example.noticias

data class UltimasNoticias(
    val items: List<Item>
) {
    val title: CharSequence?
}