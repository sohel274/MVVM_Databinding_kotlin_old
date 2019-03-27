package com.sohel.mvvm.ViewModel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.sohel.mvvm.modelData.ReponseModel
import com.sohel.mvvm.Retrofit.ApiInterface
import com.sohel.mvvm.Retrofit.ApiClient
import com.sohel.mvvm.modelData.ProgressState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivityViewModel : ViewModel() {

    var TAG = MainActivityViewModel::class.java.simpleName
    lateinit var postData: MutableLiveData<ReponseModel>
    lateinit var progressState:MutableLiveData<ProgressState>

    fun callWebService() {

        var progress  =  ProgressState()
        progress.isProgress = true
        progressState.value = progress

        var apiService = ApiClient.getClient().create(ApiInterface::class.java)
        val call = apiService.getTopRatedMovies("bitcoin&t", "4f7e4d1de39c438aac2a98fb1b3f5c97")
        call.enqueue(object : Callback<ReponseModel> {

            override fun onResponse(call: Call<ReponseModel>, response: Response<ReponseModel>) {
                Log.e(TAG, "response---> " + response.body())
                postData.value = response.body()


                var progress  =  ProgressState()
                progress.isProgress = false
                progressState.value = progress

            }

            override fun onFailure(call: Call<ReponseModel>, t: Throwable) {
                Log.e(TAG, "error---> " + t.toString())


                var progress  =  ProgressState()
                progress.isProgress = false
                progressState.value = progress

            }
        })
    }


    public fun getPost(): LiveData<ReponseModel> {
        postData = MutableLiveData()
        progressState =  MutableLiveData()
        callWebService()
        return postData;
    }


    public fun progressState() : LiveData<ProgressState>{

        return  progressState
    }







}