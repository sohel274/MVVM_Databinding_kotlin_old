package com.sohel.mvvm.modelData

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.io.Serializable


@BindingAdapter("bind:urlToImage")
fun imageUrl(view: ImageView, url: String) {
    Glide.with(view.context)
        .load(url)
        .apply(RequestOptions.circleCropTransform())
        .into(view)
}

class Articles : Serializable {


     var id: Int? = null


    val content: String? = null



    val publishedAt: String? = null



    var urlToImage: String? = null



    val url: String? = null


    val description: String? = null



    val title: String? = null


    val author: String? = null


    val source: Source? = null


}