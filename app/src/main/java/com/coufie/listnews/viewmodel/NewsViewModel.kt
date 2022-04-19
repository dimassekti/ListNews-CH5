package com.coufie.listnews.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.coufie.listnews.model.ResponseDataNewsItem
import com.coufie.listnews.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel(){

    lateinit var newsLiveData : MutableLiveData<List<ResponseDataNewsItem>>

    init {
        newsLiveData = MutableLiveData()
    }


    fun getNewsLiveDataa() : MutableLiveData<List<ResponseDataNewsItem>>{
        return newsLiveData
    }

    fun callNewsApi(){
        RetrofitClient.instance.getAllNews()
            .enqueue(object : Callback<List<ResponseDataNewsItem>>{
                override fun onResponse(
                    call: Call<List<ResponseDataNewsItem>>,
                    response: Response<List<ResponseDataNewsItem>>
                ) {
                    if(response.isSuccessful){
                        newsLiveData.postValue(response.body())
                    }else{
                        newsLiveData.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<ResponseDataNewsItem>>, t: Throwable) {
                    newsLiveData.postValue(null)
                }

            })
    }
}