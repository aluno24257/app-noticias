package com.example.noticias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://jsonplace.typicode.com/"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getUltimasNoticias();
    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<UltimasNoticias>?>) {
            override fun onResponse(
                call: Call<List<UltimasNoticias>?>,
                    response: Response<List<UltimasNoticias>?>
            )
            {
                val responseBody = response.body()!!
                val myStringBuilder = StringBuilder()
                for (myData in responseBody){
                    myStringBuilder.append(myData.id)
                    myStringBuilder.append("\n")
                }

            }
        }
            override fun onFailure(call: Call<List<UltimasNoticias>?>, t: throwable){
        }
    }

}