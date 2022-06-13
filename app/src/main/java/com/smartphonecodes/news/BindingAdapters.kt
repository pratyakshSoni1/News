package com.smartphonecodes.news

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.smartphonecodes.news.data.Article
import com.smartphonecodes.news.data.NewsPaperAdapter

    @BindingAdapter("listData")
    fun setRecyclerView(recyclerView:RecyclerView , data:List<Article>? ){
        val adapter = recyclerView.adapter as NewsPaperAdapter
        adapter.submitList(data)
        Log.d("RECYCLERVIEW","Adapter Binded \n $data")
    }
