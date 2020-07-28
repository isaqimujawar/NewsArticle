package com.codingapps.newsarticles.persistence

import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.codingapps.newsarticles.model.Fact
import com.codingapps.newsarticles.model.Topic

@Dao
interface FactDao {
   /* @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(fact:Fact):Long*/

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTopic(topic: Topic):Long

   /* @Query("SELECT * FROM facts")
    suspend fun load(): List<Fact>?*/

    @Query("SELECT * FROM topic")
    suspend fun loadTopic():Topic?
}