package com.example.demoapplicationins.activivtes


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import androidx.fragment.app.FragmentTransaction
import com.example.demoapplicationins.R
import com.example.demoapplicationins.bo.Course
import com.example.demoapplicationins.fragments.DetailFragment
import com.example.demoapplicationins.metier.dto.CourseDTO

class DetailCourseActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_COURS ="course"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_course)
        val courseDTO : CourseDTO? = intent.getParcelableExtra(EXTRA_COURS)
        var fragment = DetailFragment()
        // envoie argiment :
        val bundle = Bundle()
        bundle.putParcelable("parametre",courseDTO )
        fragment.arguments = bundle
        // transaction :
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.conteneur_detail, fragment, "exemple2")
        transaction.commit()
    }
}