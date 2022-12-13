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

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Buldier()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<MyDataItem>?>) {
            override fun onResponse(
                call: Call<List<MyDataItem>?>,
                response: Response<List<MyDataItem>?>)
            {
                val responseBody = response.body()!!
                val myStringBuilder = StringBuilder()
                for (myData in responseBody){
                    myStringBuilder.append(myData.id)
                    myStringBuilder.append("\n")
                }
            }
        }
            override fun onFailure(call: Call<List<MyDataItem>?>, t: throwable){
        }
    }

}