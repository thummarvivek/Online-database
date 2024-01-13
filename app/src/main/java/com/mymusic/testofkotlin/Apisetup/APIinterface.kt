package com.mymusic.testofkotlin.Apisetup

import retrofit2.Call
import retrofit2.http.*

interface APIinterface {

    @GET("main.php")
    fun getdata():Call<ArrayList<DataItem>>


    @POST("insertmain.php")
    @FormUrlEncoded
    fun getinsert(
        @Field("name") name: String,
        @Field("title") title: String,
        @Field("description") description: String
    ): Call<ArrayList<DataItem>>

    @POST("updatemain.php")
    fun getupdate(@Query("name") name: String,
        @Query("title") title:String,
        @Query("description") description:String,
        @Query("id") id:String
    ):Call<ArrayList<DataItem>>


    @POST("deletemain.php")
    fun getdelete(@Query("id") ID: String
    ):Call<ArrayList<DataItem>>

    @GET("search") // Replace with your API endpoint
    fun getsearchData(@Query("query") query: String?): Call<List<DataItem>>

}
