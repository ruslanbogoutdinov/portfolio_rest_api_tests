package tests;

import models.lombok.NewsFeedLombokModel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ResponseParamsCheckTests {
    @Test
    void checkCorsNewsFeedLinks(){
        List<NewsFeedLombokModel> list = given()
                .log().uri()
                .when()
                .get("https://ok.surf/api/v1/cors/news-feed")
                .then()
                .log().status()
                .log().body()
                .extract().body().jsonPath().getList("Business", NewsFeedLombokModel.class);

        assertTrue(
                list.stream().allMatch(
                        x->x.getLink().startsWith("https://news.google.com")
                )
        );
    }

    @Test
    void checkCorsNewsFeedTitles(){
        List<NewsFeedLombokModel> list = given()
                .log().uri()
                .when()
                .get("https://ok.surf/api/v1/news-feed")
                .then()
                .log().status()
                .log().body()
                .extract().body().jsonPath().getList("Business", NewsFeedLombokModel.class);

        list.forEach(
                x-> assertTrue(
                        x.getLink().startsWith("https://news.google.com")
                                && x.getLink().length() > 30
                )
        );
    }
}
