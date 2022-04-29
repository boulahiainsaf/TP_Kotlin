package com.example.demoapplicationins.activivtes


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapplicationins.R
import com.example.demoapplicationins.adapters.CoursesAdapter
import com.example.demoapplicationins.bo.Course
import com.example.demoapplicationins.fragments.DetailFragment
import com.example.demoapplicationins.metier.bdd.AppDatabaseHelper
import com.example.demoapplicationins.metier.dto.CourseDTO
import kotlin.random.Random

class ListeActivity : AppCompatActivity() {
    private  lateinit var coursesAdapter : CoursesAdapter
private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_liste)





        // liste :
        recyclerView = findViewById(R.id.liste_course)

        // à ajouter pour de meilleures performances :
        recyclerView.setHasFixedSize(true)

        // layout manager, décrivant comment les items sont disposés :
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        // contenu d'exemple :
        val listeCourses= AppDatabaseHelper.getDatabase(this).coursesDAO().getListeCourses()

        // adapter :
        coursesAdapter = CoursesAdapter(listeCourses.toMutableList(),this)
        recyclerView.adapter = coursesAdapter
        //fragment

         }
        fun clicValider(view: View) {
            val editTextCours: EditText = findViewById(R.id.course)
            val saisie = editTextCours.text.toString()
            val courseDTO =  CourseDTO(0,saisie,false)
           AppDatabaseHelper.getDatabase(this).coursesDAO().insert(courseDTO)
            var listeCourses=AppDatabaseHelper.getDatabase(this).coursesDAO().getListeCourses()
            //val course = Course(saisie, false)
            //ajouter
            coursesAdapter.updateCourses(listeCourses.toMutableList())
            recyclerView.smoothScrollToPosition(0)
            editTextCours.setText("")

        }
    fun clicSupprimer(view: View){
        var listeCourses=AppDatabaseHelper.getDatabase(this).coursesDAO().delete()

    }


}