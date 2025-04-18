package com.ceph.jwtTokens.controller.article

import com.ceph.jwtTokens.model.Article

fun Article.toArticleResponse(): ArticleResponse {
    return ArticleResponse(
        id = this.id,
        title = this.title,
        content = this.content
    )
}