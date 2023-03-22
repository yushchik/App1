package com.example.application1


//fun main(args: Array<String>) {
//    for (i in 0..9) {
//        TestStart(i).start()
//    }
//}
//
//internal class TestStart(var i: Int) : Thread() {
//    override fun run() {
//        println(i)
//    }
//}


fun main(args: Array<String>) {
    // Первый параметр: экземпляр Runnable
    // Второй параметр: своё имя (необязательно)
    val myThread = Thread(MyThread(), "Leo")
    myThread.start()
}

internal class MyThread : Runnable {
    override fun run() {
        print("Hello, I’m " + Thread.currentThread().name)
    }
}





