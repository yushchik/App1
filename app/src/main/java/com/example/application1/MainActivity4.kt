package com.example.application1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.application1.databinding.ActivityMain4Binding
import com.example.application1.listUsers.ListUsers
import com.squareup.picasso.Picasso
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity4 : AppCompatActivity() {
    private lateinit var binding: ActivityMain4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

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

        var link = ""
        service.getUsers().enqueue(object : Callback<ListUsers> {
            override fun onResponse(call: Call<ListUsers>, response: Response<ListUsers>) {
                println("RETROFIT: ${response.body()}")
                link = response.body()!!.data[0].avatar
//                setupImg(link)
            }

            override fun onFailure(call: Call<ListUsers>, t: Throwable) {
                t.printStackTrace()
            }
        })

//        Glide.with(this)
//            .load(R.drawable.img_3)
//            .circleCrop()
//            .into(binding.imageView)
//
        Glide.with(this)
            .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2FEQjYeVYv86TI-kFJ0T4mu52NIKwfTz50Q&usqp=CAU")
            .into(binding.imageView2)

        Picasso.get()
            .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2FEQjYeVYv86TI-kFJ0T4mu52NIKwfTz50Q&usqp=CAU")//Указываем, что будем загружать
            .placeholder(R.drawable.ic_launcher_foreground)//Картинка/анимация, которая будет отображаться, пока картинка не загрузится
            .error(R.drawable.ic_launcher_foreground)//Картинка, которая будет показана в случае ошибки загрузки
            .into(binding.imageView)//Указываем, куда будем загружать

    }

    fun setupImg(link: String) {
        Glide.with(this)
            .load(link)
            .into(binding.imageView2)
    }

    companion object {
        //как правило, это домен сервера
        const val BASE_URL = "https://reqres.in/"
    }
}