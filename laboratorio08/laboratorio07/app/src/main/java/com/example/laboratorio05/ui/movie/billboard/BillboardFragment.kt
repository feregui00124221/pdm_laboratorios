package com.example.laboratorio05.ui.movie.billboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.laboratorio05.R
import com.example.laboratorio05.data.models.MovieModel
import com.example.laboratorio05.databinding.FragmentBillboardBinding
import com.example.laboratorio05.ui.movie.viewmodel.MovieViewModel
import com.example.laboratorio05.ui.movie.billboard.recyclerview.MovieRecyclerViewAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton


class BillboardFragment : Fragment() {

    //  BINDING and VM block variable declaration
        private lateinit var binding: FragmentBillboardBinding
        private val movieViewModel: MovieViewModel by activityViewModels{
            MovieViewModel.Factory
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentBillboardBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.btnNavCreateNewMovie.setOnClickListener{
            movieViewModel.clearData()
            movieViewModel.clearStatus()
            it.findNavController().navigate(R.id.action_billboardFragment_to_newMovieFragment)
        }

    }

    //  Recycler view block
        private lateinit var adapter: MovieRecyclerViewAdapter

        private fun showSelectedItem(movie: MovieModel) {

            movieViewModel.setSelectedMovie(movie)

            findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)

        }

        private fun setRecyclerView(view: View){
                binding.recyclerView.layoutManager = LinearLayoutManager(view.context)

                adapter = MovieRecyclerViewAdapter { selectedMovie ->
                    showSelectedItem(selectedMovie)
                }

                binding.recyclerView.adapter = adapter

                displayMovies()

        }

        private fun displayMovies() {

            adapter.setData(movieViewModel.getMovies())

            adapter.notifyDataSetChanged()

        }
}