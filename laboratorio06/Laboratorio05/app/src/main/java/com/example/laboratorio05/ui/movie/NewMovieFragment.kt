package com.example.laboratorio05.ui.movie

import android.graphics.Movie
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.laboratorio05.R
import com.example.laboratorio05.data.models.MovieModel
import com.example.laboratorio05.databinding.FragmentNewMovieBinding

class NewMovieFragment : Fragment() {

    private lateinit var binding: FragmentNewMovieBinding

    private val viewModel: MovieViewModel by activityViewModels{
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_new_movie, container, false)
        binding = FragmentNewMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSubmit.setOnClickListener{
            CreateMovie()
        }
    }

    private fun CreateMovie(){
        val newMovie = MovieModel(
            binding.nameValue.text.toString(),
            binding.categoryValue.text.toString(),
            binding.descriptionValue.text.toString(),
            binding.qualificationValue.text.toString()
        )

        viewModel.addMovie(newMovie)

        Log.d("TAG APP", viewModel.getMovies().toString())

        findNavController().popBackStack()
    }



}