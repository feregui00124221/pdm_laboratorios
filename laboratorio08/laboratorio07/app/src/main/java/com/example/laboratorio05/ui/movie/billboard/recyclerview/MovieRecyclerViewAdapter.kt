package com.example.laboratorio05.ui.movie.billboard.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.laboratorio05.data.models.MovieModel
import com.example.laboratorio05.databinding.MovieItemBinding
import kotlinx.coroutines.NonDisposableHandle.parent

class MovieRecyclerViewAdapter(
    private val clickListener: (MovieModel) -> Unit
): RecyclerView.Adapter<MovieRecyclerViewHolder>() {

    private val movies = ArrayList<MovieModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRecyclerViewHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MovieRecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieRecyclerViewHolder, position: Int) {
        val movie = movies[position]

        holder.bind(movie, clickListener)

    }

    override fun getItemCount(): Int {
      return movies.size
    }

    fun setData(moviesList: List<MovieModel>){
        movies.clear()
        movies.addAll(moviesList)

        Log.d("TAG APP - ADAPTER", moviesList.toString())
    }

}