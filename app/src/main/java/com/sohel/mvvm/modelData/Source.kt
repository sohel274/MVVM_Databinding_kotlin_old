package com.sohel.mvvm.modelData

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Source :Serializable{
    @Expose
    @SerializedName("name")
    val name: String? = null
    @Expose
    @SerializedName("id")
    val id: String? = null
}