package com.codingapps.newsarticle.model

import androidx.room.Entity
import androidx.room.PrimaryKey
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