package com.example.laboratorio05.ui.movie.billboard.recyclerview

import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio05.data.models.MovieModel
import com.example.laboratorio05.data.movies
import com.example.laboratorio05.databinding.MovieItemBinding

class MovieRecyclerViewHolder (private val binding: MovieItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: MovieModel, clickListener: (MovieModel) -> Unit) {

        binding.titleTextView.text = movie.name

        binding.qualificationTextView.text = movie.qualification

        binding.movieItemCardView.setOnClickListener{
            Log.d("TAG APP", movie.toString())
            clickListener(movie)
        }
    }
}