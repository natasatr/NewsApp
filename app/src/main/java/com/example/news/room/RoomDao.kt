package com.example.news.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.news.model.Article

@Dao
interface RoomDao {
    @Insert
    suspend fun insertArticles(article : List<Article>)

    @Query("select * from articles")
    suspend fun getArticles():List<Article>
}