package com.example.laboratorio05

import android.app.Application
import com.example.laboratorio05.data.moviesFromDummyData
import com.example.laboratorio05.repository.MovieRepository

class MovieReviewerApplication: Application() {
    val movieRepository: MovieRepository by lazy {
        MovieRepository(moviesFromDummyData)
    }
}