package com.codingapps.newsarticle.persistence

import androidx.room.TypeConverter
import com.codingapps.newsarticle.model.Fact
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromFactListToString(facts: List<Fact>): String {
        val gson = Gson()
        return gson.toJson(facts)
    }

    @TypeConverter
    fun fromStringToFactList(data: String): List<Fact> {
        return Gson().fromJson(data, object : TypeToken<List<Fact>>() {}.type)
    }

}