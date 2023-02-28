package com.example.application1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.application1.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val list = mutableListOf<String>("Ivan", "Sasha", "Alex","Ivan", "Sasha", "Alex","Ivan", "Sasha", "Alex","Ivan", "Sasha", "Alex","Ivan", "Sasha", "Alex","Ivan", "Sasha", "Alex","Ivan", "Sasha", "Alex","Ivan", "Sasha", "Alex")

//        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        binding.recyclerView.layoutManager = layoutManager
//
//        val fieldsAdapter = CustomAdapter(list, context = this)
//        binding.recyclerView.adapter = fieldsAdapter
//

        binding.btnAlertDialog.setOnClickListener {
            openAlertDialog()
        }

        val listOfBook : MutableList<BookList> =  mutableListOf()
        listOfBook.add(BookList("Мастер и Маргарита", "Михаил Булгаков", "РФ", 1940))
        listOfBook.add(BookList("Ревизор", "Николай Гоголь", "РФ", 1836))
        listOfBook.add(BookList("Путешествия Гулливера", "Джонатан Свифт", "UK", 1726))

        val layoutManagerBook = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.rvBook.layoutManager = layoutManagerBook

        val bookListAdapter = BookListAdapter(listOfBook)
        binding.rvBook.adapter = bookListAdapter



    }

    private fun openAlertDialog(){
        MaterialAlertDialogBuilder(this, R.style.CutShapeAppearance)
            .setTitle("Title")
            .setMessage("Your message goes here. Keep it short but clear.")
            .setPositiveButton("GOT IT") { _, i -> }
            .setNegativeButton("CANCEL") { _, i -> }
            .show()
    }
}

