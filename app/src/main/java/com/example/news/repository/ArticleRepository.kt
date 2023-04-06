package com.example.finalnews.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.finalnews.api.ApiInterface
import com.example.news.model.NewsData
import com.example.news.room.ArticleDatabase

class ArticleRespository(private val apiInterface : ApiInterface,
    private val articleDatabase: ArticleDatabase)
{
    private val articlesLiveData = MutableLiveData<NewsData>()



    val articles : LiveData<NewsData>
        get() = articlesLiveData

    suspend fun getArticles(){
        val result = apiInterface.getNews()
        if(result.body() != null){

            articleDatabase.articleDao().insertArticles(result.body()!!.articles)
            articlesLiveData.postValue(result.body())
        }
    }


}