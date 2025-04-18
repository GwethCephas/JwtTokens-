package com.ceph.jwtTokens.repository

import com.ceph.jwtTokens.model.Article
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ArticleRepository {

    private val articles = listOf(
        Article(
            id = UUID.randomUUID(),
            title = "Article 1",
            content = "Content 1"
        ),
        Article(
            id = UUID.randomUUID(),
            title = "Article 2",
            content = "Content 2"
        ),
        Article(
            id = UUID.randomUUID(),
            title = "Article 3",
            content = "Content 3"
        ),
        Article(
            id = UUID.randomUUID(),
            title = "Article 4",
            content = "Content 4"
        ),
        Article(
            id = UUID.randomUUID(),
            title = "Article 5",
            content = "Content 5"
        ),

    )

    fun findAll(): List<Article> = articles
}