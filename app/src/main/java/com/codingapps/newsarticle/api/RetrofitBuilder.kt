package com.codingapps.newsarticles.api

import com.codingapps.newsarticles.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitBuilder {
    val retrofitBuilder:Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiService:ApiService by lazy {
            retrofitBuilder
                .build()
                .create(ApiService::class.java)
    }

}