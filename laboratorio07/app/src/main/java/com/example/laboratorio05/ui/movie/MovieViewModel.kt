package com.example.laboratorio05.ui.movie

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.laboratorio05.MovieReviewerApplication
import com.example.laboratorio05.data.models.MovieModel
import com.example.laboratorio05.repository.MovieRepository

class MovieViewModel(private val repository:MovieRepository): ViewModel() {

    var name = MutableLiveData<String>("")
    var category = MutableLiveData<String>("")
    var description = MutableLiveData<String>("")
    var qualification = MutableLiveData<String>("")
    var status = MutableLiveData<String>("")

    fun getMovies() = repository.getMovies()

    fun addMovie(movie: MovieModel) = repository.addMovie(movie)

    private fun validateData(): Boolean{

        when {
            name.value.isNullOrEmpty() -> return false
            category.value.isNullOrEmpty() -> return false
            description.value.isNullOrEmpty() -> return false
            qualification.value.isNullOrEmpty() -> return false
        }

        return true
    }

    fun createMovie(){

        if(!validateData()){
            status.value = WRONG_DATA
            return
        }

        val newMovie = MovieModel(
            name.value.toString(),
            category.value.toString(),
            description.value.toString(),
            qualification.value.toString()
        )

        addMovie(newMovie)

        status.value = MOVIE_CREATED

    }


    fun clearData(){
        name.value = ""
        category.value = ""
        description.value = ""
        qualification.value = ""
    }

    fun clearStatus(){
        status.value = BASE_STATE
    }

    companion object{
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MovieReviewerApplication
                MovieViewModel(app.movieRepository)
            }
        }

        const val MOVIE_CREATED = "Movie created!"
        const val WRONG_DATA = "Wrong data entered or hasn't been entered."
        const val BASE_STATE = "Base state of new movie has been set or reset."
    }
}