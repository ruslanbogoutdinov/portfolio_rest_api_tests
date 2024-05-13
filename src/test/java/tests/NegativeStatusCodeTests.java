package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class NegativeStatusCodeTests {
    @Test
    void checkCorsNewsFeedNegativeStatusCode(){
        given()
                .log().uri()
                .when()
                .get("https://ok.surf/api/v1/cors/news-feed")
                .then()
                .log().status()
                .log().body()
                .statusCode(400);
    }

    @Test
    void checkCorsNewsSectionNamesNegativeStatusCode(){
        given()
                .log().uri()
                .when()
                .get("https://ok.surf/api/v1/cors/news-section-names")
                .then()
                .log().status()
                .log().body()
                .statusCode(400);
    }

    @Test
    void checkNewsFeedNegativeStatusCode(){
        given()
                .log().uri()
                .when()
                .get("https://ok.surf/api/v1/news-feed")
                .then()
                .log().status()
                .log().body()
                .statusCode(400);
    }
}
