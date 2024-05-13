package tests;

import io.restassured.http.ContentType;
import models.lombok.NewsSectionLombokModel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class SuccessStatusCodeTests {
    @Test
    void checkCorsNewsFeedSuccessfulStatusCode(){
        given()
                .log().uri()
        .when()
                .get("https://ok.surf/api/v1/cors/news-feed")
        .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    void checkCorsNewsSectionNamesSuccessfulStatusCode(){
        given()
                .log().uri()
        .when()
                .get("https://ok.surf/api/v1/cors/news-section-names")
        .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    void checkNewsFeedSuccessfulStatusCode(){
        given()
                .log().uri()
        .when()
                .get("https://ok.surf/api/v1/news-feed")
        .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }

    @Test
    void checkNewsSectionSuccessfulStatusCode(){
        List<String> params = List.of("Business", "Sports", "Technology");

        NewsSectionLombokModel newsSectionLombokModel = new NewsSectionLombokModel();
        newsSectionLombokModel.setSections(params);

        NewsSectionLombokModel responseModel = given()
                .log().uri()
                .body(newsSectionLombokModel)
                .contentType(ContentType.JSON)
        .when()
                .post("https://ok.surf/api/v1/news-section")
        .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().as(NewsSectionLombokModel.class);

        //todo провека ответа
    }

    @Test
    void checkNewsSectionNamesSuccessfulStatusCode(){
        given()
                .log().uri()
        .when()
                .get("https://ok.surf/api/v1/news-section-names")
        .then()
                .log().status()
                .log().body()
                .statusCode(200);
    }
}
