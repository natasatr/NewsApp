package com.example.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.finalnews.api.ApiInterface
import com.example.finalnews.api.ApiUtil
import com.example.finalnews.repository.ArticleRespository
import com.example.finalnews.viewmodel.ArticlesViewModel
import com.example.news.databinding.ActivityMainBinding
import com.example.news.viewmodel.ArticlesViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var articlesViewModel: ArticlesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

      val respository = (application as MyApplication).articlesRepository

        articlesViewModel = ViewModelProvider(this, ArticlesViewModelFactory(respository)).get(
            ArticlesViewModel::class.java)

        articlesViewModel.articles.observe(this, Observer {
           it.articles.iterator().forEach {
               Log.i("TAG", "MESSAGE ${it}" )
           }
        })

    }

}