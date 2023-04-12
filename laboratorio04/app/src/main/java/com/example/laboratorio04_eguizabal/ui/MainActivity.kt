package com.example.laboratorio04_eguizabal.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.laboratorio04_eguizabal.R
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: TextInputEditText
    private lateinit var mailEditText: TextInputEditText
    private lateinit var phoneEditText: TextInputEditText
    private lateinit var saveBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.name_field)
        mailEditText = findViewById(R.id.mail_field)
        phoneEditText = findViewById(R.id.phone_field)
        saveBtn = findViewById(R.id.SaveBtn)

        saveBtn.setOnClickListener{
            val intent = Intent(this, ShareActivity::class.java)
            intent.putExtra("name", nameEditText.text.toString())
            intent.putExtra("mail", mailEditText.text.toString())
            intent.putExtra("phone", phoneEditText.text.toString())
            startActivity(intent)
        }
    }
}