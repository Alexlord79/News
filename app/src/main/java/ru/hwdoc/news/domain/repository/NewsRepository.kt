package ru.hwdoc.news.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.hwdoc.news.domain.entity.Article

interface NewsRepository {

    fun getAllSubscriptions(): Flow<List<String>>

    suspend fun addSubscription(topic: String)

    suspend fun updateArticlesForTopic(topic: String)

    suspend fun removeSubscription(topic: String)

    suspend fun updateArticlesForAllSubscriptions()

    fun getArticlesByTopics(topics: List<String>): Flow<List<Article>>

    suspend fun clearAllArticles(topics: List<String>)
}