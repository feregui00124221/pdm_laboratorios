package com.example.laboratorio05.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.laboratorio05.R
import com.example.laboratorio05.databinding.FragmentMovieBinding
import com.example.laboratorio05.databinding.FragmentNewMovieBinding

class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_movie, container, false)
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

}