package com.coufie.listnews.network

import com.coufie.listnews.model.ResponseDataNewsItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("news")
    fun getAllNews(): Call<List<ResponseDataNewsItem>>
}