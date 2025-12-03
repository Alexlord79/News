package ru.hwdoc.news.domain.usecase

import ru.hwdoc.news.domain.repository.NewsRepository
import javax.inject.Inject

class GetAllSubscriptionsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {

    operator fun invoke() = newsRepository.getAllSubscriptions()
}