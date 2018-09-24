package com.kong.samples.article.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.kong.samples.article.vo.Article;

/**
 * 文章
 */
@Entity
@Table(name = "tbl_kg_article")
@PrimaryKeyJoinColumn(name = "id")
public class ArticleInfo {

    public ArticleInfo(){

    }
    public ArticleInfo(Article article) {
        this.id = article.getId();
        this.userId = article.getUserId();
        this.title = article.getTitle();
        this.summary = article.getSummary();
        this.status = article.getStatus();
        this.type = article.getType();
    }

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;
    private String title; // ("测试文章000000");
    private Integer type; // (1);
    private Integer status; // (2);
    private String summary; // ("这是一篇测试文章");

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