package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import static io.restassured.RestAssured.given;

public class ResponseJSONSchemeTests {
    @Test
    void checkCorsNewsSectionNamesSuccessfulStatusCode(){
        given()
                .log().uri()
        .when()
                .get("https://ok.surf/api/v1/cors/news-section-names")
        .then()
                .log().status()
                .log().body()
                .body(matchesJsonSchemaInClasspath("schemes/news_section_response_scheme.json"));
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
                .body(matchesJsonSchemaInClasspath("schemes/news_section_response_scheme.json"));
    }
}
