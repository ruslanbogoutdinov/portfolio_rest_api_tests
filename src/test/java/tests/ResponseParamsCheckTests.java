package tests;

import io.qameta.allure.*;
import models.lombok.NewsFeedLombokModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.annotations.Layer;

import java.util.List;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static specs.BaseSpec.baseRequestSpec;
import static specs.BaseSpec.baseResponseSpec;

@Layer("rest api")
@Feature("Провера параметров запроса")
@Owner("Ruslan Bogoutdinov")
public class ResponseParamsCheckTests {
    @Test
    @Story("Проверка параметра 'link'")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Проверка параметра 'link' у запроса на получение списка новостей (CORS)")
    void checkCorsNewsFeedLinks() {
        List<NewsFeedLombokModel> list = step("Отправка запроса на получение списка новостей (CORS)", () ->
                given(baseRequestSpec)
                .when()
                        .get("https://ok.surf/api/v1/cors/news-feed")
                .then()
                        .spec(baseResponseSpec)
                        .extract().body().jsonPath().getList("Business", NewsFeedLombokModel.class));

        step("Проверка на соответствие параметра 'link' нужному страндарту 'https://news.google.com'", () -> {
            assertTrue(
                    list.stream().allMatch(
                            x -> x.getLink().startsWith("https://news.google.com")
                    )
            );
        });
    }

    @Test
    @Story("Проверка параметра 'title'")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Проверка параметра 'title' у запроса на получение списка новостей")
    void checkCorsNewsFeedTitles() {
        List<NewsFeedLombokModel> list = step("Отправка запроса на получение списка новостей", () ->
                given(baseRequestSpec)
                .when()
                        .get("https://ok.surf/api/v1/news-feed")
                .then()
                        .spec(baseResponseSpec)
                        .extract().body().jsonPath().getList("Business", NewsFeedLombokModel.class));

        step("Проверка на соответствие параметра 'link' нужному страндарту 'https://news.google.com'", () -> {
            list.forEach(
                    x -> assertTrue(
                            x.getLink().startsWith("https://news.google.com")
                                    && x.getLink().length() > 30
                    )
            );
        });
    }
}
