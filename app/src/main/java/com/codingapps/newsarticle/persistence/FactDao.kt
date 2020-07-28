package com.codingapps.newsarticle.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.codingapps.newsarticle.model.Topic

@Dao
interface FactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTopic(topic: Topic): Long

    @Query("SELECT * FROM topic")
    suspend fun loadTopic(): Topic?
}