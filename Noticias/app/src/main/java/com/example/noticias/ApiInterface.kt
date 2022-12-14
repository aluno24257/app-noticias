package com.example.noticias

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("api/getT")
    fun getData(): Call<List<Item>>
}