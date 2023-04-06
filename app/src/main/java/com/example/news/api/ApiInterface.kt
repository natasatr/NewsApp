package com.example.finalnews.api

import com.example.news.model.NewsData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("top-headlines?apiKey=fb6bd5c8fee841d5a6f21145b7c81021&country=rs")
    suspend fun getNews() : Response<NewsData>//proslijediti kao Query u fju
}