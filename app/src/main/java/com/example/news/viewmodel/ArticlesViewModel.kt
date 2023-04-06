package com.example.finalnews.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalnews.repository.ArticleRespository
import com.example.news.model.NewsData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class ArticlesViewModel(private val articlesRespository: ArticleRespository) : ViewModel() {


    init{
        viewModelScope.launch {
            articlesRespository.getArticles()
        }
    }

    val articles : LiveData<NewsData>
        get() = articlesRespository.articles
}