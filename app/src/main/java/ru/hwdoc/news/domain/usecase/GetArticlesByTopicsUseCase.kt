package ru.hwdoc.news.domain.usecase

import kotlinx.coroutines.flow.Flow
import ru.hwdoc.news.domain.entity.Article
import ru.hwdoc.news.domain.repository.NewsRepository
import javax.inject.Inject

class GetArticlesByTopicsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(topics: List<String>): Flow<List<Article>> {
        return newsRepository.getArticlesByTopics(topics)
    }
}