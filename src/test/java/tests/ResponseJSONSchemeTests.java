package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.annotations.Layer;

import static io.qameta.allure.Allure.step;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import static io.restassured.RestAssured.given;
import static specs.BaseSpec.baseRequestSpec;
import static specs.BaseSpec.baseResponseSpec;

@Layer("rest api")
@Feature("Провера JSON схем")
@Owner("Ruslan Bogoutdinov")
public class ResponseJSONSchemeTests {
    @Test
    @Story("Проверка JSON схемы у новостей")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка на JSON схему для заголовков новостей (CORS)")
    void checkCorsNewsSectionNamesSuccessfulStatusCode(){
        step("Отправка запроса на проверку JSON схемы у заголовков новостей (CORS)", () -> {
            given(baseRequestSpec)
            .when()
                    .get("/cors/news-section-names")
            .then()
                    .spec(baseResponseSpec)
                    .body(matchesJsonSchemaInClasspath("schemes/news_section_response_scheme.json"));
        });
    }

    @Test
    @Story("Проверка JSON схемы у новостей")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка на JSON схему для заголовков новостей")
    void checkNewsSectionNamesSuccessfulStatusCode(){
        step("Отправка запроса на проверку JSON схемы у заголовков новостей", () -> {
            given(baseRequestSpec)
            .when()
                    .get("/news-section-names")
            .then()
                    .spec(baseResponseSpec)
                    .body(matchesJsonSchemaInClasspath("schemes/news_section_response_scheme.json"));
        });
    }
}
