package com.example.demoapplicationins.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.example.demoapplicationins.R
import com.example.demoapplicationins.bo.Course
import com.example.demoapplicationins.metier.dto.CourseDTO

class DetailFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
        val bundle = requireArguments()
        val courseDTO: CourseDTO? = bundle.getParcelable("parametre")
        val textView:TextView = view.findViewById(R.id.textk)
        textView.text=courseDTO.toString()

    }

}