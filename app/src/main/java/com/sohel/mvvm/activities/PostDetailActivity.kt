package com.sohel.mvvm.activities

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.sohel.mvvm.R
import com.sohel.mvvm.databinding.PostDetailBinding
import com.sohel.mvvm.modelData.Articles


class PostDetailActivity:BaseActivity() {

    var articles:Articles? = null
    lateinit  var binding: PostDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadBundle()
        binding =   DataBindingUtil.setContentView(this@PostDetailActivity, R.layout.post_detail)
        init()
        binding.articles =  articles
        binding.notifyChange()


       /* var dbArticle:TableArticle =  TableArticle()
        dbArticle.titledb = articles?.title
        dbArticle.authordb = articles?.author

        dbArticle?.let {
            AppDatabase.getDatabase(this@PostDetailActivity)?.articleDao()?.insert(
                it
            )
        }*/

    }

    fun init(){

    }


    fun loadBundle(){

        try{

            articles =  intent.getSerializableExtra("post") as Articles

        }catch (e:Exception){

        }
    }

}