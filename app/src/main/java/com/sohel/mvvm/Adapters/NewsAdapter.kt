package com.sohel.mvvm.Adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.sohel.mvvm.Interfaces.MyItemClick
import com.sohel.mvvm.modelData.Articles
import com.sohel.mvvm.R
import com.sohel.mvvm.databinding.ListItemBinding


class NewsAdapter(val userList: ArrayList<Articles>, val myItemClick: MyItemClick) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {


    private var layoutInflater: LayoutInflater? = null

    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)


        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.context)
        }

        var  binder: ListItemBinding =  DataBindingUtil.inflate(this!!.layoutInflater!!, R.layout.list_item, parent, false)
        return ViewHolder(binder)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        holder.binding.articles =  userList[position]
        holder.binding.tvTitle.setOnClickListener {
            myItemClick.myClick(position)
        }
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return userList.size
    }

    //the class is hodling the list view
    inner class ViewHolder(public val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.getRoot())
}
