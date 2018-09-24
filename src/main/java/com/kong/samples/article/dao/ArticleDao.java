package com.kong.samples.article.dao;

import com.kong.samples.article.model.ArticleInfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * DAO负责增删改查，分页查询等基本功能
 */
@Repository
public interface ArticleDao extends JpaRepository<ArticleInfo,Long> {

}