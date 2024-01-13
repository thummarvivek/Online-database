package com.mymusic.testofkotlin


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mymusic.testofkotlin.Apisetup.APIinterface
import com.mymusic.testofkotlin.Apisetup.ApiClient
import com.mymusic.testofkotlin.Apisetup.DataItem
import com.mymusic.testofkotlin.Apisetup.MyAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Nextpage : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nextpage)
        recyclerView=findViewById(R.id.recycler_view)
        recyclerView.layoutManager=LinearLayoutManager(this)

        val API :APIinterface=ApiClient().getApiClient()!!.create(APIinterface::class.java)
        API.getdata().enqueue(object :Callback<ArrayList<DataItem>>{
            override fun onResponse(
                call: Call<ArrayList<DataItem>>,
                response: Response<ArrayList<DataItem>>
            ) {
              recyclerView.adapter= MyAdapter( response.body()!!,this@Nextpage)
            }

            override fun onFailure(call: Call<ArrayList<DataItem>>, t: Throwable) {

            }
        })

    }
    fun Onclickmove(view: View){
        val intent =Intent(this,MainActivity2::class.java)
        startActivity(intent)

    }
}