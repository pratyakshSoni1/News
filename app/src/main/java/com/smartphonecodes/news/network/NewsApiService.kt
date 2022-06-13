package com.smartphonecodes.news.network

import com.smartphonecodes.news.data.NewsResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://newsapi.org"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

object NewsApi{
    val retrofitService:NewsApiService by lazy {
        retrofit.create(NewsApiService::class.java)
    }
}

interface NewsApiService {
    @GET("v2/everything")
    suspend fun getTheSpecificNews(
        @Query("q") topic:String="Uttar+Pradesh+elections+2022" ,
        @Query("sortBy") sortByTechnique:String="publishedAt" ,
        @Query("apiKey") keyToSite:String="be883c01498841eab43cac1f92548e02"

    ):NewsResponse

    @GET("v2/top-headlines")
    suspend fun getTheHeadlines(
        @Query("q") topic:String="India" ,
        @Query("sortBy") sortByTechnique:String="popularity" ,
        @Query("country") country:String="in" ,
        @Query("category") category: String="general" ,
        @Query("apiKey") keyToSite:String="be883c01498841eab43cac1f92548e02"

    ):NewsResponse

}

//        apiKey:String = "be883c01498841eab43cac1f92548e02"