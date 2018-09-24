package com.kong.samples.article.service;

import com.kong.samples.article.vo.Article;
/**
 * Article Service Interface
 */
public interface ArticleService {
    void saveArticle(Article article);
    Article getArticle(Long id);
    void updateArticle(Article article);
    void deleteArticle(Article article);
}