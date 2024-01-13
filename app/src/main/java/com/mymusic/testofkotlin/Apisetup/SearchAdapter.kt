package com.mymusic.testofkotlin.Apisetup

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mymusic.testofkotlin.R
import com.mymusic.testofkotlin.searchdemof.Course
import com.mymusic.testofkotlin.searchdemof.CustomRecyclerAdapter
import com.squareup.picasso.Picasso

//class CustomRecyclerAdapter(val context : Context, var courseList: ArrayList<Course>) : RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder>() {

class SearchAdapter(private  var data: ArrayList<DataItem>,private  val context: Context):RecyclerView.Adapter<SearchAdapter.Myclass>() {


    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAdapter.Myclass {
      val view =LayoutInflater.from(context).inflate(R.layout.list_custom2,parent,false)
        return  Myclass(view)
    }

    override fun onBindViewHolder(holder: SearchAdapter.Myclass, position: Int) {
        holder.name.text=data[position].name
        holder.title.text=data[position].title
        holder.description.text=data[position].description
        holder.onlyme.setText("success")
        Picasso.get().load(data.get(position).image).into(holder.image)
    }

    override fun getItemCount(): Int =data.size

    class Myclass (view: View):RecyclerView.ViewHolder(view){
        var name=view.findViewById<TextView>(R.id.tex1)
        var title=view.findViewById<TextView>(R.id.tex2)
        var description=view.findViewById<TextView>(R.id.tex3)
        var onlyme=view.findViewById<TextView>(R.id.tex4)
        var image =view.findViewById<ImageView>(R.id.img1)


    }

    fun filterlist(filteredCourseList :ArrayList<DataItem>){
        this.data =filteredCourseList;
        notifyDataSetChanged()
    }


}