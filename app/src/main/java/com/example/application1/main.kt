package com.example.application1

import android.opengl.ETC1.isValid
import java.lang.Math.sqrt

val intV = 4


//fun main(args: Array<String>) {
//
//
//}

//class A {
//    private lateinit var prop: String
//    fun setUp() {
//        prop = "100 + 200"
//    }
//
//    fun display() {
//        println(prop)
//    }
//}

//fun main(args: Array<String>) {
//    val a = A()
//    a.setUp()
//    a.display()
//}

class A {
    private lateinit var prop: String
    fun setUp() {
        prop = "100 + 200 "
    }
    fun display() {
        println(prop)
    }
}
fun main(args: Array<String>) {
    val a = A()
    a.setUp()
    a.display()
}

fun sum(vararg numbers: Double) {
    var result: Double = 0.0
    val text :String? = null
    for (n in numbers)
        result += n
    println("The sum of digits are: $result")

}
