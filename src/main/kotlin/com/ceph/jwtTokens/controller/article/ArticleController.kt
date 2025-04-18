package com.ceph.jwtTokens.controller.article

import com.ceph.jwtTokens.service.ArticleService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/article")
class ArticleController(
    private val articleService: ArticleService
) {

    @GetMapping
    fun getArticles(): List<ArticleResponse> =
        articleService.findAll()
            .map { it.toArticleResponse() }
}