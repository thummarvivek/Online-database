package com.mymusic.testofkotlin.searchdemof

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mymusic.testofkotlin.R

class searchdemo : AppCompatActivity() {

    lateinit var adapter: CustomRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searchdemo)

        val rvRecyclerView = findViewById<RecyclerView>(R.id.sample_recyclerView)
        val sample_editText=findViewById<EditText>(R.id.sample_editText)

        rvRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        adapter = CustomRecyclerAdapter(this, Helper.Companion.getVersionsList())
        rvRecyclerView.adapter = adapter


        sample_editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                filter(p0.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
    }

    fun filter(text: String) {

        val filteredCourseAry: ArrayList<Course> = ArrayList()

        val courseAry : ArrayList<Course> = Helper.Companion.getVersionsList()

        for (eachCourse in courseAry) {
            if (eachCourse.courseName!!.toLowerCase().contains(text.toLowerCase()) || eachCourse.courseDescrip!!.toLowerCase().contains(text.toLowerCase())) {
                filteredCourseAry.add(eachCourse)
            }
        }

        //calling a method of the adapter class and passing the filtered list
        adapter.filterList(filteredCourseAry);
    }
}