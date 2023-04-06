package com.example.news.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.finalnews.repository.ArticleRespository
import com.example.finalnews.viewmodel.ArticlesViewModel

class ArticlesViewModelFactory (private val articlesRepository: ArticleRespository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ArticlesViewModel(articlesRepository) as T
        }
    }