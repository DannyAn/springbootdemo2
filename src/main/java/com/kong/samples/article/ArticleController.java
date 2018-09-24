package com.kong.samples.article;

import com.kong.core.result.ResponseResult;
import com.kong.core.result.ResultGenerator;
import com.kong.samples.article.service.ArticleService;
import com.kong.samples.article.vo.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 基本RESTful API 示例列表 接口URL HTTP方法 接口说明 /article POST 保存文章 /article/{id} GET
 * 查询文章列表 /article/{id} DELETE 删除文章 /article/{id} PUT 更新文章信息
 */
@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "/article", method = RequestMethod.POST, produces = "application/json")
    public ResponseResult<String> saveArticle(@RequestBody Article article) {
        article.setUserId(1L);
        ResponseResult<String> response = null;
        try {
            articleService.saveArticle(article);
            response = ResultGenerator.genSuccessResult(article.getTitle());
        } catch (RuntimeException ex) {
            response = ResultGenerator.genFailResult(ex.getMessage());
        } catch (Exception ex) {
            response = ResultGenerator.genFailResult(ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseResult<String> updateArticle(@PathVariable Long id, @RequestBody Article article) {
        article.setId(id);
        ResponseResult<String> response = null;
        try {
            articleService.updateArticle(article);
            response = ResultGenerator.genSuccessResult(article.toString());
        } catch (RuntimeException ex) {
            response = ResultGenerator.genFailResult(ex.getMessage());
        } catch (Exception ex) {
            response = ResultGenerator.genFailResult(ex.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseResult<Article> getArticle(@PathVariable Long id) {
        ResponseResult<Article> response = null;
        Article article = null;
        try {
            article = articleService.getArticle(id);
            response = ResultGenerator.genSuccessResult(article);
        } catch (RuntimeException ex) {
            // 前端简化提示信息
            response = ResultGenerator.genFailResult(ex.getMessage(), article);
            // TODO 后端详细logger日志
            // logger.error("get article error:",ex);
        } catch (Exception ex) {
            response = ResultGenerator.genFailResult(ex.getMessage(), article);
            // TODO 后端详细logger日志
            // logger.error("get article error:",ex);
        }
        return response;
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseResult<String> deleteArticle(@PathVariable Long id) {
        /*
         * //软删除 Article article = articleService.getById(id); article.setStatus(-1);
         * articleService.updateArticle(article);
         */
        // 直接删除
        ResponseResult<String> response = null;
        try {
            Article article = new Article();
            article.setId(id);
            articleService.deleteArticle(article);
            response = ResultGenerator.genSuccessResult();
        } catch (RuntimeException ex) {
            // 前端简化提示信息
            response = ResultGenerator.genFailResult(ex.getMessage());
            // TODO 后端详细logger日志
            // logger.error("get article error:",ex);
        } catch (Exception ex) {
            response = ResultGenerator.genFailResult(ex.getMessage());
            // TODO 后端详细logger日志
            // logger.error("get article error:",ex);
        }
        return response;
    }
}