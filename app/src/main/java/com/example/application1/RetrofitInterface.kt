package com.example.application1


import com.example.application1.listUsers.ListUsers
import com.example.application1.person.Person
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {

    @GET("api/users?page=2")
    fun getUsers():Call<ListUsers>


    //будьте внимательны с импортами. В данном случае нам необходимы импорты из библиотеки retrofit2
    @GET("api/users")
    fun getUsersByPage(@Query("page") page: Int):Call<ListUsers>




}