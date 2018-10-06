package com.kong.samples.article;

import com.google.gson.Gson;
import com.jayway.restassured.RestAssured;
import com.kong.core.result.ResponseResult;
import com.kong.core.result.ResultGenerator;
import com.kong.samples.App;
import com.kong.samples.article.vo.Article;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@IntegrationTest({"server.port:0",
        "spring.datasource.url:jdbc:h2:mem:sampledb;DB_CLOSE_ON_EXIT=FALSE"})
public class ArticleControllerTest {

    @Value("${local.server.port}")
    int port;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
    }

    @Test
    public void saveArticle() {
        Article article = new Article();
        String title = "Test Title";
        article.setTitle(title);
        String  summary ="a little doggy.";
        article.setSummary(summary);
        Gson gson = new Gson();

        //final String bodyString = "{\"customerId\": \"CDICC\",\"broker\": \"test\",\"editUserId\": \"wadexu\"}";
        final String bodyString = gson.toJson(article);
        given().contentType("application/json").
                request().body(bodyString).
                expect().
                log().body().
//                log().all().
                statusCode(200).
                body("code",equalTo(200)).
                body("message",equalTo(ResultGenerator.DEFAULT_SUCCESS_MESSAGE)).
                body("data.title",equalTo(title)).
                body("data.summary",equalTo(summary)).
                when().post("/article");
               /*
                body(

                        "order.orderNumber", is(Number.class),
                        "order.deleteDate", is(nullValue()),
                        "success", equalTo(true)).
                when().post("/article");
        */
    }

    @Test
    public void updateArticle() {
        Article article = new Article();
        article.setTitle("Test Title");
        article.setSummary("test summary");
        Gson gson = new Gson();
        //final String bodyString = "{\"customerId\": \"CDICC\",\"broker\": \"test\",\"editUserId\": \"wadexu\"}";
        final String bodyString = gson.toJson(article);
        given().contentType("application/json").
                request().body(bodyString).
                expect().
                statusCode(200).
                body(
                        "order.orderNumber", is(Number.class),
                        "order.deleteDate", is(nullValue()),
                        "success", equalTo(true)).
                when().put("/article/{articleId}",1);
    }

    @Test
    public void getArticle() {
        when().get("/article/1")
                .then()
                .body("answer", is(nullValue()));
    }

    @Test
    public void deleteArticle() {
    }

    @Test
    public void testAuthentication() {
        expect().
                statusCode(401).
                when().
                get("/service/user");

        expect().
                statusCode(200).
                when().
                with().
                authentication().basic("wadexu", "123456").
                get("/article/user");
    }

}