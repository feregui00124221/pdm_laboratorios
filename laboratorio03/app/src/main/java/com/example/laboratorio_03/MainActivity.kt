package com.example.laboratorio_03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var btnfivecents: ImageView
    private lateinit var btntencents: ImageView
    private lateinit var btnquartercents: ImageView
    private lateinit var btndollarcents: ImageView
    private lateinit var tvContador: TextView

    private val five = 0.05
    private val ten = 0.10
    private val quarter = 0.25
    private val dollar = 1.00
    private var contador_aux = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()

        clickListenersFunction()
    }

    private fun bind(){
        btnfivecents = findViewById(R.id.image_five_cents)
        btntencents = findViewById(R.id.ten_cents)
        btnquartercents = findViewById(R.id.quarter_cents)
        btndollarcents = findViewById(R.id.dollar_cents)

        tvContador = findViewById(R.id.contador)
    }

    private fun clickListenersFunction(){

        btnfivecents.setOnClickListener {
//            contador_aux = tvContador.text.toString().toDouble()
            contador_aux += five
            contador_aux = String.format("%.2f", contador_aux).toDouble()
            tvContador.text = "$${contador_aux}"
        }

        btntencents.setOnClickListener {
//            contador_aux = tvContador.text.toString().toDouble()
            contador_aux += ten
            contador_aux = String.format("%.2f", contador_aux).toDouble()
            tvContador.text = "$${contador_aux}"
        }

        btnquartercents.setOnClickListener {
//            contador_aux = tvContador.text.toString().toDouble()
            contador_aux += quarter
            contador_aux = String.format("%.2f", contador_aux).toDouble()
            tvContador.text = "$${contador_aux}"
        }

        btndollarcents.setOnClickListener {
//            contador_aux = tvContador.text.toString().toDouble()
            contador_aux += dollar
            contador_aux = String.format("%.2f", contador_aux).toDouble()
            tvContador.text = "$${contador_aux}"
        }


    }


}