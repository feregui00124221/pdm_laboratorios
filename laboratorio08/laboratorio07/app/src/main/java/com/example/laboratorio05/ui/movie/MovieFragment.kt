package com.example.laboratorio05.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.laboratorio05.R
import com.example.laboratorio05.data.models.MovieModel
import com.example.laboratorio05.data.name
import com.example.laboratorio05.databinding.FragmentMovieBinding
import com.example.laboratorio05.databinding.FragmentNewMovieBinding
import com.example.laboratorio05.ui.movie.viewmodel.MovieViewModel

class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding
    private val movieViewModel: MovieViewModel by activityViewModels{
        MovieViewModel.Factory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_movie, container, false)
        binding = FragmentMovieBinding.inflate(inflater, container, false)

        Log.d("TAG APP", movieViewModel.name.value.toString())

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewmodel = movieViewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }

}
