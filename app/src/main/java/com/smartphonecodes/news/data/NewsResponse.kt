package com.smartphonecodes.news.data

data class NewsResponse (
    val articles:List<Article> ,
    val status : String ,
    val totalResults:Int
)