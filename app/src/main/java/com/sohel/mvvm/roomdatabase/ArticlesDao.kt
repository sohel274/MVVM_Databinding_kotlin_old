package com.sohel.mvvm.roomdatabase

import android.arch.persistence.room.*
import com.sohel.mvvm.modelData.TableArticle

@Dao
public interface ArticlesDao {

    @Query("SELECT * FROM articles")
    fun getAllArticles(): ArrayList<TableArticle>

    @Insert
    fun insert(articles: TableArticle)

    @Delete
    fun delete(articles: TableArticle)

    @Update
    fun update(articles: TableArticle)

}