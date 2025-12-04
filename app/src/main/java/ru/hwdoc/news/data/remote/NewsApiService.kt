package ru.hwdoc.news.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("v2/everything?apiKey=ffbbceabb5a4494eb29fd6dbae5d78c2")
    suspend fun loadArticles(
        @Query("q") topic: String
    ): NewsResponseDto
}