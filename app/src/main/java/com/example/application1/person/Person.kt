package com.example.application1.person


import com.google.gson.annotations.SerializedName

data class Person(
    @SerializedName("data")
    val data: Data,
    @SerializedName("support")
    val support: Support
)