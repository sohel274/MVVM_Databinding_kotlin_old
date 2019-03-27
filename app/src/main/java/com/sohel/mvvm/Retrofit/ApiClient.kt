package com.sohel.mvvm.Retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object  ApiClient {


    private var retrofit: Retrofit? = null
    val BASE_URL = "https://newsapi.org/v2/"


    fun getClient(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return this.retrofit!!
    }

}