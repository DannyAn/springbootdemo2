package com.kong.samples.article.service;

import com.kong.samples.article.dao.ArticleDao;
import com.kong.samples.article.model.ArticleInfo;
import com.kong.samples.article.vo.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Article Service Implementation
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    /**
     * 在Spring Framework 4.3以后，如果你只有一个Constructor, 就不再需要写@Autowired，Spring会默认他是autowire目标:  
     * @param articleDao
     */
    ArticleServiceImpl(ArticleDao articleDao)
    {
        this.articleDao = articleDao;
    }

    @Autowired
    ArticleDao articleDao;

    @Override
    public void saveArticle(Article article) {
        ArticleInfo info = new ArticleInfo(article);
        articleDao.save(info);
        article.setId(info.getId());
    }

    @Override
    public void updateArticle(Article article) {
        ArticleInfo info = new ArticleInfo(article);
        articleDao.saveAndFlush(info);
    }

    @Override
    public Article getArticle(Long id) {
        ArticleInfo info = articleDao.getOne(id);
        return new Article(info);
    }

    @Override
    public void deleteArticle(Article article) {
        articleDao.delete(article.getId());
    }

}