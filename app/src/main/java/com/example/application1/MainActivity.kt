package com.example.application1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.application1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listOfBook: MutableList<BookList> = mutableListOf()
        listOfBook.add(BookList(0, "Мастер и Маргарита", "Михаил Булгаков", "РФ", 1940))
        listOfBook.add(BookList(1, "Ревизор", "Николай Гоголь", "РФ", 1836))
        listOfBook.add(BookList(2, "Путешествия Гулливера", "Джонатан Свифт", "UK", 1726))

        val layoutManagerBook = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.rvBook.layoutManager = layoutManagerBook

        val bookListAdapter = BookListAdapter(listOfBook, applicationContext)
        binding.rvBook.adapter = bookListAdapter

    }

}

