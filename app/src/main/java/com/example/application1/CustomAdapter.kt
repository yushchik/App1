package com.example.application1

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.application1.databinding.ItemCustomAdapterBinding
import com.google.android.material.snackbar.Snackbar


class CustomAdapter(private val dataSet: MutableList<String>, val context: Context) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    class ViewHolder(private val binding: ItemCustomAdapterBinding, val context: Context) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String, index: Int) {

            with(binding) {
                if (index % 2 == 0) {
                    cl.setBackgroundResource(R.color.purple_500)

                }

                img.setImageResource(R.drawable.ic_launcher_background)
                tv.text = item
                btn.setOnClickListener {
                    if (item == "Ivan")
                        Snackbar
                            .make(root, tv.text, Snackbar.LENGTH_LONG)
                            .show()
                    else {
                        tv.text = "Darya"
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(viewGroup.context)
        val binding = ItemCustomAdapterBinding.inflate(inflater, viewGroup, false)
        return ViewHolder(binding, context)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(dataSet[position], position)
    }

    override fun getItemCount() = dataSet.size


}