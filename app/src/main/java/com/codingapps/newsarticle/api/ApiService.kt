
package com.codingapps.newsarticles.api

import com.codingapps.newsarticles.model.Topic
import retrofit2.http.GET

interface ApiService {
    /*@GET("facts")
    suspend fun getFacts():Response<FactResponse>
    @GET("placeholder/blogs")
    fun getFacts(): Response<List<BlogPost>>
*/
    @GET("2iodh4vg0eortkl/facts.json")
    suspend fun getFacts(): Topic
}
