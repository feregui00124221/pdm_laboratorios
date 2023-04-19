package com.example.laboratorio05_eguizabalfernando

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BillboardFragment : Fragment() {

    private lateinit var actionNavToCreateMovie: FloatingActionButton
    private lateinit var actionNavToMovieFragment: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_billboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        actionNavToCreateMovie = view.findViewById(R.id.btn_nav_to_create_movie)

        actionNavToCreateMovie.setOnClickListener{
            it.findNavController().navigate(R.id.action_billboardFragment_to_createMovieFragment)
//            view.findNavController().navigate(R.id.action_billboardFragment_to_createMovieFragment) SOLUCION ALTERNATIVA
        }

        actionNavToMovieFragment = view.findViewById(R.id.cardView01)

        actionNavToMovieFragment.setOnClickListener{
            it.findNavController().navigate(R.id.action_billboardFragment_to_movieFragment)
//            view.findNavController().navigate(R.id.action_billboardFragment_to_createMovieFragment) SOLUCION ALTERNATIVA
        }
    }

}