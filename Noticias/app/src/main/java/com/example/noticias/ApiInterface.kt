package com.example.noticias

import retrofit2.Call

interface ApiInterface {

    @Get( value:"posts")
    fun getData(): Call<List<UltimasNoticias>>
}