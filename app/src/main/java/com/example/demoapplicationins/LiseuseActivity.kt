package com.example.demoapplicationins

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class LiseuseActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liseuse)

        val textV:TextView = findViewById(R.id.text)
        textV.setMovementMethod(ScrollingMovementMethod())
        Toast.makeText(this, "Bienvenue !", Toast.LENGTH_LONG).show()

    }
    fun clicValider(view: View) {
        val but: Button = findViewById(R.id.retour)
        but.setOnClickListener { Toast.makeText(this, "Vous êtes revenu au début de l'article !", Toast.LENGTH_LONG).show() }
        val intent = Intent(this, LiseuseActivity::class.java)
        startActivity(intent)
        val textV:TextView = findViewById(R.id.text)
        textV.setMovementMethod(ScrollingMovementMethod())

    }
}