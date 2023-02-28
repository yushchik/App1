package com.example.application1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.application1.databinding.ItemBookBinding

class BookListAdapter(private val bookList: MutableList<BookList>) :
    RecyclerView.Adapter<BookListAdapter.ViewHolder>() {


    class ViewHolder(
        private val binding: ItemBookBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(book: BookList) {

            with(binding) {
                tvName.text = book.name + book.author
                tvAuthor.text = book.author
                tvCountry.text = book.country
                tvYear.text = book.year.toString()

            }
        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(viewGroup.context)
        val binding = ItemBookBinding.inflate(inflater, viewGroup, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(bookList[position])

    }

    override fun getItemCount() = bookList.size

}