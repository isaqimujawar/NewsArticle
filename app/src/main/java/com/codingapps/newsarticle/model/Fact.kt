package com.codingapps.newsarticles.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "facts")
data class Fact (
    @PrimaryKey(autoGenerate = true)
    @Expose
    @SerializedName("id")
    val id: Int? = null,
    @Expose
    @SerializedName("title")
    val title: String?,
    @Expose
    @SerializedName("description")
    val description: String?,
    @Expose
    @SerializedName("imageHref")
    val imageHref: String?
)