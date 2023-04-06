package com.example.news.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "articles")
data class Article(
    @PrimaryKey(autoGenerate = true)// da li smijem ovo ovako dodati
    val id : Int,
    @SerializedName("author")
    val author: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("content")
    val content: String=""

)