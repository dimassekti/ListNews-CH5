package com.coufie.listnews.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.coufie.listnews.R
import com.coufie.listnews.model.ResponseDataNewsItem
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>(){

    private var datanews : List<ResponseDataNewsItem>? = null

    fun setDataNews(news : List<ResponseDataNewsItem>){
        this.datanews = news
    }
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val tampilanUi = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)

        return ViewHolder(tampilanUi)
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        holder.itemView.tv_news_title.text = datanews!![position].title
        holder.itemView.tv_news_date.text = datanews!![position].createdAt
        holder.itemView.tv_news_author.text = datanews!![position].author

        this.let {
            Glide.with(holder.itemView.context).load(datanews!![position].image).into(holder.itemView.iv_news)
        }
    }

    override fun getItemCount(): Int {
        if(datanews == null){
            return 0
        }else{
            return datanews!!.size
        }
    }

}