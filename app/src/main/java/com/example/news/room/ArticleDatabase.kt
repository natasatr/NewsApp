package com.example.news.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.news.model.Article

@Database(entities = [Article::class], version = 2)
abstract class ArticleDatabase : RoomDatabase(){

    abstract  fun articleDao() : RoomDao
    companion object{
        private var INSTANCE : ArticleDatabase?=null

        fun getDatabase(context: Context) : ArticleDatabase{
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context,
                    ArticleDatabase::class.java,
                    "articlesDB"
                ).addMigrations().build()
            }



            return INSTANCE!!
        }
    }
}
//private val MIGRATIONS = arrayOf(
//    MIGRATION_1_2,
//)
//
//private object MIGRATION_1_2 : Migration(1, 2) {
//    override fun migrate(database: SupportSQLiteDatabase) {
//        database.execSQL("")
//    }
//}