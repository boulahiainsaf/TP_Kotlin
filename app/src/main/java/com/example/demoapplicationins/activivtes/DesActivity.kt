package com.example.demoapplicationins.activivtes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.demoapplicationins.R
import kotlin.random.Random

class DesActivity : AppCompatActivity() {
    private lateinit var boutton1 : TextView
    private lateinit var boutton2 : TextView
    private lateinit var boutton3 : TextView
    private var b1:Int = 0
    private var b2:Int = 0
    private var b3:Int = 0
    companion object{
        private const val  B1="b1"
        private const val  B2="b2"
        private const val  B3="b3"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_des)
        boutton1 = findViewById(R.id.boutton1)
        boutton2 = findViewById(R.id.boutton2)
        boutton3 = findViewById(R.id.boutton3)
        b1 = Random.nextInt(1, 7)
        b2 = Random.nextInt(1, 7)
        b3 == Random.nextInt(1, 7)


        if (savedInstanceState != null)
        {
            // récupérations :
            b1 = savedInstanceState.getInt(B1)
            b2 = savedInstanceState.getInt(B2)
            b3 = savedInstanceState.getInt(B3)
        }
        boutton1.text=b1.toString()
        boutton2.text=b2.toString()
        boutton3.text=b3.toString()
    }
    override fun onSaveInstanceState(outState: Bundle) {

        outState.putInt(B1, b1)
        outState.putInt(B2, b2)
        outState.putInt(B3, b3)

        super.onSaveInstanceState(outState)

    }



}