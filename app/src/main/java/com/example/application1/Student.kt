package com.example.application1

//example 1
//data class Student(
//    val name: String,
//    val surName: String,
//    val age: Int,
//    val address: String,
//    val isMen: Boolean
//)


//example 2
//data class Student(
//    val name: String,
//    val surName: String,
//    val age: Int,
//    val address: Address,
//    val isMen: Boolean
//)
//
//data class Address(
//    val country: String,
//    val city: String,
//    val street: String,
//    val buildNumber: String
//)

//example 3
data class Student(
    val name: String,
    val surName: String,
    val age: Int,
    val address: Address,
    val isMen: Boolean,
    val assessment: MutableList<Int>
)

data class Address(
    val country: String,
    val city: String,
    val street: String,
    val buildNumber: String
)