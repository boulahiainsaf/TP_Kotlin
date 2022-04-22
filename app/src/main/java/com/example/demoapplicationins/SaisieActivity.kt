package com.example.demoapplicationins

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SaisieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saisie)
        val sai: EditText= findViewById(R.id.text)
        val button:Button = findViewById(R.id.valider)
        button.setOnClickListener {

            val saisie:String = sai.text.toString()
            Log.i("montag", "text saisie :$saisie")
            val intent = Intent(this, PrincipaleActivity::class.java)
            intent.putExtra(PrincipaleActivity.SAISI_TEXT,saisie)
            startActivity(intent)
        }
    }
}