package com.example.news

import android.app.Application
import com.example.finalnews.api.ApiInterface
import com.example.finalnews.api.ApiUtil
import com.example.finalnews.repository.ArticleRespository
import com.example.news.room.ArticleDatabase

class MyApplication : Application(){

    lateinit var articlesRepository : ArticleRespository
    override fun onCreate() {
        super.onCreate()

        val apiInterface = ApiUtil.getRetrofitInstance().create(ApiInterface::class.java)

        val database = ArticleDatabase.getDatabase(applicationContext)
        articlesRepository = ArticleRespository(apiInterface,database)
    }
}