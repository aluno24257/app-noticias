package com.example.noticias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

const val BASE_URL = "https://jsonplace.typicode.com/"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getUltimasNoticias();
    }

    private fun getUltimasNoticias() {
        val retrofitBuilder = Retrofit.Buldier()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder
    }

}