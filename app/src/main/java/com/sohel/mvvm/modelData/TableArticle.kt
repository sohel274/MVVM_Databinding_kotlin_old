package com.sohel.mvvm.modelData

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.io.Serializable




@Entity(tableName = "TableArticle")
data class TableArticle( @PrimaryKey(autoGenerate = true)  var id: Int? = null,


                          @ColumnInfo(name = "title")
    var titledb: String? = null,

    @ColumnInfo(name = "author")
    var authordb: String? = null




)