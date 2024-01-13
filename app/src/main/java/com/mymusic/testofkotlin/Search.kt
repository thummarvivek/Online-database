package com.mymusic.testofkotlin


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mymusic.testofkotlin.Apisetup.APIinterface
import com.mymusic.testofkotlin.Apisetup.ApiClient
import com.mymusic.testofkotlin.Apisetup.DataItem
import com.mymusic.testofkotlin.Apisetup.SearchAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Search : AppCompatActivity() {


   lateinit var  recyclerView: RecyclerView
   lateinit var searchView: SearchView
   lateinit var adapter: SearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        recyclerView = findViewById(R.id.recycler)
        searchView = findViewById(R.id.searchView)

        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
           query?.let {
//               performSearch(it)
           }
        return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
              return true
            }

        })

        recyclerView.layoutManager= LinearLayoutManager(this,RecyclerView.VERTICAL,false)
        val Api :APIinterface=ApiClient().getApiClient()!!.create(APIinterface::class.java)

//        Api.getdata().enqueue(object :Callback<ArrayList<DataItem>>{
//            override fun onResponse(
//                call: Call<ArrayList<DataItem>>,
//                response: Response<ArrayList<DataItem>>
//            ) {
//                recyclerView.adapter = SearchAdapter(response.body()!!,this@Search)
//
//            }
//
//            override fun onFailure(call: Call<ArrayList<DataItem>>, t: Throwable) {
////                Toast.makeText(this@Search,"${t.message}",Toast.LENGTH_SHORT).show()
//            }
//
//        })

    }


//    private fun performSearch(query: String) {
//        val api: APIinterface = ApiClient().getApiClient()?.create(APIinterface::class.java)!!
//        api.getsearchData(query).enqueue(object : Callback<ArrayList<DataItem>>{
//            override fun onResponse(
//                call: Call<ArrayList<DataItem>>,
//                response: Response<ArrayList<DataItem>>
//            ) {
//                if (response.isSuccessful) {
//                    val searchData = response.body()
//                    searchData?.let {
//                        adapter = SearchAdapter(it, this@Search)
//                        recyclerView.adapter = adapter
//                    }
//                } else {
//                    // Handle unsuccessful response
//                }
//            }
//
//
//            override fun onFailure(call: Call<ArrayList<DataItem>>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//
//        })
//
//    }

//    fun filter(text: String) {
//
//        val filteredCourseAry: ArrayList<DataItem> = ArrayList()
//
//        val courseAry : ArrayList<DataItem> = Helper.Companion.getVersionsList()
//
//        for (eachCourse in courseAry) {
//            if ()
//            if (eachCourse.courseName!!.toLowerCase().contains(text.toLowerCase()) || eachCourse.courseDescrip!!.toLowerCase().contains(text.toLowerCase())) {
//                filteredCourseAry.add(eachCourse)
//            }
//        }
//
//        //calling a method of the adapter class and passing the filtered list
//        adapter.filterList(filteredCourseAry);
//    }



}




