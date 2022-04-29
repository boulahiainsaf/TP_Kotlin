package com.example.demoapplicationins.activivtes


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button
import android.widget.ScrollView

import android.widget.Toast
import com.example.demoapplicationins.R

class MainActivity : AppCompatActivity() {
    private lateinit var scrollView: ScrollView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var boutton : Button=findViewById(R.id.retour)
        scrollView  = findViewById(R.id.scroll_view_article);
        Toast.makeText(this, "Bienvenue !", Toast.LENGTH_LONG).show()

        boutton.setOnClickListener {
            Toast.makeText(this, "Vous êtes revenu au début de l'article !", Toast.LENGTH_LONG).show()
            scrollView.scrollTo(0,0);


        }
    }
}