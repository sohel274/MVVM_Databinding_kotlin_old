package com.sohel.mvvm.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Button
import com.sohel.mvvm.Adapters.NewsAdapter
import com.sohel.mvvm.Interfaces.MyItemClick
import com.sohel.mvvm.R
import com.sohel.mvvm.ViewModel.MainActivityViewModel
import com.sohel.mvvm.modelData.Articles
import com.sohel.mvvm.modelData.ReponseModel
import com.sohel.mvvm.modelData.TableArticle
import com.sohel.mvvm.roomdatabase.AppDatabase

public class MainActivity : BaseActivity() {

    lateinit var rvList: RecyclerView
    lateinit var context: Context
    var TAG = MainActivity::class.java.simpleName
    lateinit var viewModel: MainActivityViewModel
    lateinit var articleList: ArrayList<Articles>
    lateinit var  bSeeAll:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this


        init()

    }

    fun init() {
        articleList = arrayListOf()
        bSeeAll =  findViewById(R.id.bSeeAll)
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java);
        rvList = findViewById(R.id.rvList)
        rvList.layoutManager = LinearLayoutManager(context)
        viewModel.getPost().observe(this, Observer {
            displayToRecyclerView(it!!)
        })

        viewModel.progressState().observe(this, Observer {

            if (it!!.isProgress) {
                showLoading()
            } else {
                hideLoading()
            }
        })



        bSeeAll.setOnClickListener {


        }


       // GetAllArticleTask().execute()


    }


    public fun displayToRecyclerView(response: ReponseModel) {
        Log.e(TAG, "final response---> " + response.articles)
        articleList.addAll(response.articles!!)
        var adapter = NewsAdapter(articleList, myClick)
        rvList.adapter = adapter
    }

    var myClick: MyItemClick = object : MyItemClick {

        override fun myClick(position: Int) {

            var i  =  Intent(this@MainActivity,PostDetailActivity::class.java)
            i.putExtra("post",articleList[position] )
            startActivity(i)

        }

    }


    inner class GetAllArticleTask : AsyncTask<Void, Void, Void>() {

        override fun doInBackground(vararg params: Void?): Void? {


            var  sbArticleList:ArrayList<TableArticle>  = AppDatabase.getDatabase(this@MainActivity)!!.articleDao().getAllArticles()

            for(i in sbArticleList.indices){

                Log.e(TAG , "title---> "+sbArticleList[i].titledb)
            }

            return  null
        }
    }


}
