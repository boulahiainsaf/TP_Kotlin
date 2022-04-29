package com.example.demoapplicationins.adapters

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapplicationins.R
import com.example.demoapplicationins.activivtes.DetailCourseActivity
import com.example.demoapplicationins.bo.Course
import com.example.demoapplicationins.fragments.DetailFragment
import com.example.demoapplicationins.metier.dto.CourseDTO

class CoursesAdapter(private var listeCourses: MutableList<CourseDTO>, private val activity:FragmentActivity) : RecyclerView.Adapter<CoursesAdapter.CourseViewHolder>()
{
    // Crée chaque vue item à afficher :
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder
    {
        val viewCourse = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_course, parent, false)
        return CourseViewHolder(viewCourse)
    }

    // Renseigne le contenu de chaque vue item :
    override fun onBindViewHolder(holder: CourseViewHolder, position: Int)
    {
        holder.textViewLibelleCourse.text = listeCourses[position].intitule
        holder.switchAcheteCourse.isChecked = listeCourses[position].achete

    }

    override fun getItemCount(): Int = listeCourses.size

@SuppressLint("NotifyDataSetChanged")
fun updateCourses(listeCourses: MutableList<CourseDTO>)
{
    this.listeCourses=listeCourses
    notifyDataSetChanged()
}

    // ViewHolder :
    inner class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val textViewLibelleCourse: TextView = itemView.findViewById(R.id.intitule_course)
        val switchAcheteCourse : SwitchCompat= itemView.findViewById(R.id.achete_course)
        init {
            itemView.setOnClickListener{
                val courseDTO = listeCourses[adapterPosition]
                //Toast.makeText(itemView.context,course.toString(),Toast.LENGTH_LONG).show()

                if (activity.findViewById<FrameLayout>(R.id.conteneur_detail)!=null)
                {
                   //tablette :
                    var fragment = DetailFragment()
                    // envoie argiment :
                    val bundle = Bundle()
                    bundle.putParcelable("parametre",courseDTO )
                    fragment.arguments = bundle
                    // transaction :
                    val transaction: FragmentTransaction = activity.supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.conteneur_detail, fragment, "exemple2")
                    transaction.commit()
                }
                else
                {
                    //smartphone:
                    val intent = Intent(itemView.context,DetailCourseActivity::class.java)
                    intent.putExtra(DetailCourseActivity.EXTRA_COURS,courseDTO)
                    itemView.context.startActivity(intent)
                }


            }
        }
    }
}