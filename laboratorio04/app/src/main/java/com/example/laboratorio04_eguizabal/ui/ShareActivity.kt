package com.example.laboratorio04_eguizabal.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.laboratorio04_eguizabal.R

class ShareActivity : AppCompatActivity() {

    private lateinit var nameTV: TextView
    private lateinit var mailTV: TextView
    private lateinit var phoneTV: TextView
    private lateinit var shareBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        nameTV = findViewById(R.id.name_show)
        mailTV = findViewById(R.id.mailShow)
        phoneTV = findViewById(R.id.phoneShow)
        shareBTN = findViewById(R.id.shareBtn)

        val name = intent.getStringExtra("name").toString()
        val mail = intent.getStringExtra("mail").toString()
        val phone = intent.getStringExtra("phone").toString()

        nameTV.text = "\bNombre: ${name}"
        mailTV.text = "\bCorreo: ${mail}"
        phoneTV.text = "\bTelefono: ${phone}"

        shareBTN.setOnClickListener{
            val intent = Intent(this, ShareActivity::class.java)

            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, name + mail + phone)
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }


    }
}