package com.smartphonecodes.news.data

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.smartphonecodes.news.databinding.NewItemViewBinding
import com.smartphonecodes.news.ui.MainFragment

class NewsPaperAdapter(val clickListener:NewsClickListener):ListAdapter<Article , NewsPaperAdapter.NewsViewHolder >(DiffCallback) {


    class NewsViewHolder(
        var binding: NewItemViewBinding
    ) : RecyclerView.ViewHolder(binding.root){

        fun bind(article: Article , clickListenerForFullArticle: NewsClickListener) {
            binding.newsResponse = article
            binding.clickListener = clickListenerForFullArticle
            Log.d("Navigation","Listener Set")
            binding.executePendingBindings()
        }


    }

    companion object DiffCallback:DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return NewsViewHolder(NewItemViewBinding.inflate(layoutInflater,parent,false))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = getItem(position)
        holder.bind(article,clickListener)
    }



}
class NewsClickListener(val xclickListener:(() -> Unit)){

    fun openNews() = xclickListener
}