package ru.hwdoc.news.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {

    @Query("SELECT * FROM subscriptions")
    fun getAllSubscription(): Flow<List<SubscriptionDbModel>>

    @Insert(onConflict = IGNORE)
    suspend fun addSubscription(subscriptionDbModel: SubscriptionDbModel)

    @Transaction
    @Delete
    suspend fun deleteSubscription(subscriptionDbModel: SubscriptionDbModel)

    @Query("SELECT * FROM articles WHERE topic IN (:topics) ORDER BY publishedAt DESC")
    fun getAllArticlesByTopics(topics: List<String>): List<ArticleDbModal>

    @Insert(onConflict = IGNORE)
    suspend fun addArticles(articles: List<ArticleDbModal>)

    @Query("DELETE FROM articles WHERE topic in (:topics)")
    suspend fun deleteArticlesByTopics(topics: List<String>)
}