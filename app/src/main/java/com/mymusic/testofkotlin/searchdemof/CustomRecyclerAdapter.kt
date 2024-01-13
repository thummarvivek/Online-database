package com.mymusic.testofkotlin.searchdemof

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mymusic.testofkotlin.R


class CustomRecyclerAdapter(val context : Context, var courseList: ArrayList<Course>) : RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder>() {

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0?.txtTitle?.text = courseList[p1].courseName
        p0?.txtContent?.text = courseList[p1].courseDescrip
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.recycler_view_item, p0, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return courseList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTitle = itemView.findViewById<TextView>(R.id.appOSTitle_txtVw)
        val txtContent = itemView.findViewById<TextView>(R.id.appOSDetails_txtVw)
    }

    // To get the data to search Category
    fun filterList(filteredCourseList: ArrayList<Course>) {
        this.courseList = filteredCourseList;
        notifyDataSetChanged();
    }
}