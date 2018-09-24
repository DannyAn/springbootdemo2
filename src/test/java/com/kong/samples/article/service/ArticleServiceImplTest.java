package com.kong.samples.article.service;

import com.kong.samples.article.dao.ArticleDao;
import com.kong.samples.article.model.ArticleInfo;
import com.kong.samples.article.vo.Article;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.MockitoAnnotations.*;

public class ArticleServiceImplTest {
    //Mock注解为一个interface提供一个虚拟的实现。
    @Mock
    ArticleDao articleDao;

    private ArticleService articleService;

    private ArticleInfo articleEntity = new ArticleInfo();
    @Before
    public void setUp()
    {
        //用于初始化@Mock注解修饰的组件
        initMocks(this);
        articleService = new ArticleServiceImpl(articleDao);
    }

    @Test
    public void saveArticle() {
        //when(articleDao.save()).thenReturn(null);
    }

    @Test
    public void updateArticle() {
    }

    @Test
    public void getArticle() {
        Mockito.when(articleDao.getOne(Mockito.anyLong())).thenReturn(articleEntity);
        Article curArticle = articleService.getArticle(new Long(1));
        assertNull(curArticle.getId());
        assertNull(articleEntity.getId());
        assertEquals(curArticle.getId(),articleEntity.getId());
    }

    @Test
    public void deleteArticle() {
    }
}