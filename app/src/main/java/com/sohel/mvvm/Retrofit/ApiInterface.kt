package com.sohel.mvvm.Retrofit

import com.sohel.mvvm.modelData.ReponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


public interface ApiInterface {

    @GET("everything")
    fun getTopRatedMovies(@Query("q") query:String, @Query("apiKey") apikey:String): Call<ReponseModel>



}