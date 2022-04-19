package com.coufie.listnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.coufie.listnews.adapter.NewsAdapter
import com.coufie.listnews.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvNews.layoutManager = LinearLayoutManager(this)
        rvNews.adapter = NewsAdapter()

        getDataNews()
    }


    fun getDataNews(){
        val viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        viewModel.getNewsLiveDataa().observe(this, Observer {
            if(it != null){
                NewsAdapter().setDataNews(it)
                NewsAdapter().notifyDataSetChanged()
                Log.d("tes", it.toString())
            }
        })
        viewModel.callNewsApi()
    }
}