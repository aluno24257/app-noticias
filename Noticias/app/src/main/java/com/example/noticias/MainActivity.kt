package com.example.noticias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.jvm.internal.CompletedContinuation.context

const val BASE_URL = "https://jsonplace.typicode.com/"
class MainActivity : AppCompatActivity() {

    lateinit var myAdapter: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerview_users.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager (context:this)

        getMyData()
    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<UltimasNoticias>?> {
            override fun onResponse(
                call: retrofit2.Call<List<UltimasNoticias>?>,
                response: Response<List<UltimasNoticias>?>
            ) {
                val responseBody = response.body()!!

                myAdapter = MyAdapter(baseContext, responseBody)
                myAdapter.notifyDataSetChanged()
                recyclerview_users.adapter = myAdapter
            }

            override fun onFailure(call: retrofit2.Call<List<UltimasNoticias>?>, t: Throwable) {
                d("MainActivity", "onFailure : " + t.message)
            }
        })
    }