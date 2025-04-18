package com.ceph.jwtTokens.service

import com.ceph.jwtTokens.model.Article
import com.ceph.jwtTokens.repository.ArticleRepository
import org.springframework.stereotype.Service

@Service
class ArticleService(
    private val articleRepository: ArticleRepository
) {

    fun findAll(): List<Article> = articleRepository.findAll()
}
