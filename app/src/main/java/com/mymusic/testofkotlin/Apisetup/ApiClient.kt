package com.mymusic.testofkotlin.Apisetup

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

public class ApiClient {
    public var BASE_URL: String ="https://vivekthummarandroid.000webhostapp.com/Testmain/"
    public var retrofit: Retrofit? =null

    public fun getApiClient(): Retrofit?{
        if (retrofit == null){
            retrofit =Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit
    }

}