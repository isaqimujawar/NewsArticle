package com.codingapps.newsarticle.api

import com.codingapps.newsarticle.model.Topic
import retrofit2.http.GET

interface ApiService {

    @GET("2iodh4vg0eortkl/facts.json")
    suspend fun getFacts(): Topic
}
