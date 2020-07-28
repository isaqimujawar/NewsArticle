package com.codingapps.newsarticles.persistence

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.codingapps.newsarticles.model.Fact
import com.codingapps.newsarticles.model.Topic
import com.codingapps.newsarticles.repository.Repository

@Database(
    entities = [Topic::class],
    version = 1)
@TypeConverters(Converters::class)
abstract class FactDatabase : RoomDatabase(){

    abstract fun getFactDao():FactDao

    companion object {
        @Volatile
        private var instance: FactDatabase? = null
        private val LOCK = Any()
        private val DATABASE_NAME: String = "facts.db"

        operator fun invoke(application: Application) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(application).also { instance = it }
        }


        private fun createDatabase(application: Application) =
            Room.databaseBuilder(
                application.applicationContext,
                FactDatabase::class.java,
                DATABASE_NAME
            ).build()
    }
}