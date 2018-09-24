package com.kong.samples.article.vo;

import com.kong.samples.article.model.ArticleInfo;

/**
 * 文章值对象
 */
public class Article {

    private Long id;
    private Long userId;
    private String title; // ("测试文章000000");
    private Integer type; // (1);
    private Integer status; // (2);
    private String summary; // ("这是一篇测试文章");
    public Article(){
        
    }
    public Article(ArticleInfo article) {
        this.id = article.getId();
        this.userId = article.getUserId();
        this.title = article.getTitle();
        this.summary = article.getSummary();
        this.status = article.getStatus();
        this.type = article.getType();
    }
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * @param summary the summary to set
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

}