package com.example.demoapplicationins.activivtes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.example.demoapplicationins.R

class PrincipaleActivity : AppCompatActivity() {
    private var progressBar: ProgressBar? = null
    private var i = 0
    private var txtView: TextView? = null
    private val handler = Handler()
    companion object {
    const val  SAISI_TEXT ="variabel"
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principale)
        var textchange:TextView=findViewById(R.id.saisie)
        val valeurSi= intent.getStringExtra(SAISI_TEXT)
        if (valeurSi!==null){


            textchange.text = valeurSi
        }
        // finding progressbar by its id
        progressBar = findViewById<ProgressBar>(R.id.progress_Bar) as ProgressBar

        // finding textview by its id
        txtView = findViewById<TextView>(R.id.text_view)

        // finding button by its id
        val btn = findViewById<Button>(R.id.show_button)

        // handling click on button
        btn.setOnClickListener {
            textchange.text=""
            // Before clicking the button the progress bar will invisible
            // so we have to change the visibility of the progress bar to visible
            // setting the progressbar visibility to visible
            progressBar!!.visibility = View.VISIBLE

            i = progressBar!!.progress

            Thread(Runnable {
                // this loop will run until the value of i becomes 99
                while (i < 100) {
                    i += 1
                    // Update the progress bar and display the current value
                    handler.post(Runnable {
                        progressBar!!.progress = i
                        // setting current progress to the textview
                        txtView!!.text = i.toString() + "/" + progressBar!!.max
                    })
                    try {
                        Thread.sleep(100)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }

                // setting the visibility of the progressbar to invisible
                // or you can use View.GONE instead of invisible
                // View.GONE will remove the progressbar
                progressBar!!.visibility = View.INVISIBLE
                if(progressBar!!.visibility===View.INVISIBLE){
                    val intent = Intent(this, SaisieActivity::class.java)
                    startActivity(intent)
                }

            }).start()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.menu_applic, menu)
        return true
    }
}