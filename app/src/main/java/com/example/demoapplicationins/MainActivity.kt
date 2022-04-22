package com.example.demoapplicationins

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var boutton : Button=findViewById(R.id.retour)
        Toast.makeText(this, "Bienvenue !", Toast.LENGTH_LONG).show()
        val intent = Intent(this, LiseuseActivity::class.java)

        boutton.setOnClickListener {
            Toast.makeText(this, "Vous êtes revenu au début de l'article !", Toast.LENGTH_LONG).show()
            startActivity(intent)
        }
    }
}