package com.example.application1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.application1.listUsers.ListUsers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        //Создаем перехватчик
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
        //Создаем клиент и добавляем туда перехватчик
        val okHttpCLient = OkHttpClient.Builder()
            .addInterceptor(interceptor)

            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpCLient)
            .build()

        val service = retrofit.create(RetrofitInterface::class.java)

        service.getUsers().enqueue(object : Callback<ListUsers> {
            override fun onResponse(call: Call<ListUsers>, response: Response<ListUsers>) {
                println("RETROFIT: ${response.body()}")
            }

            override fun onFailure(call: Call<ListUsers>, t: Throwable) {
                t.printStackTrace()
            }
        })

    }

    companion object {
        //как правило, это домен сервера
        const val BASE_URL = "https://reqres.in/"
    }
}