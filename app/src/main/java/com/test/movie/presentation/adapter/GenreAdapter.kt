package com.test.movie.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.test.movie.R
import com.test.movie.databinding.ItemGenreBinding
import com.test.movie.domain.model.Genre
import com.test.movie.util.Detail

class GenreAdapter(
    private val detailType: Detail
) : ListAdapter<Pair<Int, String>, GenreAdapter.ViewHolder>(DiffCallback) {
    inner class ViewHolder(val view: ItemGenreBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), R.layout.item_genre, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.apply {
            detailType = this@GenreAdapter.detailType
            genre = Genre(id = getItem(position).first, name = getItem(position).second)
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<Pair<Int, String>>() {
        override fun areItemsTheSame(
            oldItem: Pair<Int, String>, newItem: Pair<Int, String>
        ): Boolean = oldItem.first == newItem.first

        override fun areContentsTheSame(
            oldItem: Pair<Int, String>, newItem: Pair<Int, String>
        ): Boolean = oldItem == newItem
    }
}