package com.sohel.mvvm.modelData

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable


public class ReponseModel :Serializable {


    @Expose
    @SerializedName("articles")
    val articles: ArrayList<Articles>? = null
    @Expose
    @SerializedName("totalResults")
     val totalResults: Int = 0
    @Expose
    @SerializedName("status")
     val status: String? = null




}
