package com.example.laboratorio05.repository

import android.util.Log
import com.example.laboratorio05.data.models.MovieModel

class MovieRepository(private val movies: MutableList<MovieModel>) {
    fun getMovies(): MutableList<MovieModel> {
        Log.d("TAG APP - REPO", movies.toString())
        return movies
    }

    fun addMovie(newMovie: MovieModel) = movies.add(newMovie)
}