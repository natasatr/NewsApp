package com.example.finalnews.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtil {

    val BASEURL="https://newsapi.org/v2/"

    fun getRetrofitInstance() : Retrofit {

        return Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(
                GsonConverterFactory
                    .create()
            )
            .build()

    }
}
