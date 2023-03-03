package com.example.application1

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import com.example.application1.databinding.ItemBookBinding


class BookListAdapter(private val bookList: MutableList<BookList>, val context: Context) :
    RecyclerView.Adapter<BookListAdapter.ViewHolder>() {


    class ViewHolder(
        private val binding: ItemBookBinding,
        private val context: Context
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(book: BookList) {

            with(binding) {

                when (book.index) {
                    0 -> {
                        img.setImageResource(R.drawable.img)
                        val bitmap1: Bitmap =
                            BitmapFactory.decodeResource(context.resources, R.drawable.img)
                        createPalette(bitmap1, binding)
                    }
                    1 -> {
                        img.setImageResource(R.drawable.img_1)
                        val bitmap1: Bitmap =
                            BitmapFactory.decodeResource(context.resources, R.drawable.img_1)
                        createPalette(bitmap1, binding)
                    }
                    2 -> {
                        img.setImageResource(R.drawable.img_2)
                        val bitmap1: Bitmap =
                            BitmapFactory.decodeResource(context.resources, R.drawable.img_2)
                        createPalette(bitmap1, binding)
                    }
                }

                tvName.text = book.name + book.author
                tvAuthor.text = book.author
                tvCountry.text = book.country
                tvYear.text = book.year.toString()

            }
        }

        private fun createPalette(bitmap: Bitmap, binding: ItemBookBinding) {
            Palette.from(bitmap).generate { palette ->
                val defaultValue = 0x000000
                binding.root.setBackgroundColor(palette!!.getDominantColor(defaultValue))
            }
        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(viewGroup.context)
        val binding = ItemBookBinding.inflate(inflater, viewGroup, false)
        return ViewHolder(binding, context)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(bookList[position])

    }

    override fun getItemCount() = bookList.size

}