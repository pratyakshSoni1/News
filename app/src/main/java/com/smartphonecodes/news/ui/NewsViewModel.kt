package com.smartphonecodes.news.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smartphonecodes.news.data.Article
import com.smartphonecodes.news.data.NewsResponse
import com.smartphonecodes.news.network.NewsApi
import com.smartphonecodes.news.network.NewsApiService
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class NewsViewModel : ViewModel() {

    var _status = MutableLiveData<String>()
    val status:LiveData<String> = _status

    var _newsResponse = MutableLiveData<NewsResponse>()
    val newsResponse:LiveData<NewsResponse> = _newsResponse

    var _firstNews = MutableLiveData<Article>()
    val firstNews:LiveData<Article> = _firstNews

    init{
        getApiResponse()
    }

    fun getApiResponse(){
        Log.d("VIEWMODEL","GETTING DATA")
        try{
            _status.value = "LOADING"
            Log.d("VIEWMODEL","STATUS LOADiNG")
            viewModelScope.launch {
                Log.d("VIEWMODEL","STATUS IN SCOPE")
                _newsResponse.value = NewsApi.retrofitService.getTheSpecificNews()
                Log.d("VIEWMODEL","GOT SOME RESPONSE")
                Log.d("VIEWMODEL","${newsResponse.value?.articles?.get(0)?.description}")
                _firstNews.value = newsResponse.value?.articles?.get(0)
                _status.value = newsResponse.value?.status
            }
        }catch(e:Exception){
            Log.d("VIEWMODEL","ERROR")
            _status.value = "$e"

        }
    }

}