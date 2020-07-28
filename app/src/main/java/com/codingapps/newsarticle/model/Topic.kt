package com.codingapps.newsarticles.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.codingapps.newsarticles.model.Fact
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "topic")
data class Topic(
    @PrimaryKey(autoGenerate = true)
    @Expose
    @SerializedName("id")
    val id: Int? = null,
    @Expose
    @SerializedName("rows")
    val rows: List<Fact>?,
    @Expose
    @SerializedName("title")
    val title: String?
)