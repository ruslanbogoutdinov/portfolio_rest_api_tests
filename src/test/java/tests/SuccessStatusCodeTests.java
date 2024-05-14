package tests;

import io.qameta.allure.*;
import models.lombok.NewsSectionLombokModel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.annotations.Layer;

import java.util.List;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static specs.BaseSpec.baseRequestSpec;
import static specs.BaseSpec.baseResponseSpec;

@Layer("rest api")
@Feature("Позитивные тесты на статус код")
@Owner("Ruslan Bogoutdinov")
public class SuccessStatusCodeTests {
    @Test
    @Story("Получение списка новостей (CORS)")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Позитивная проверка на статус код при получении списка новостей (CORS)")
    void checkCorsNewsFeedSuccessfulStatusCode(){
        step("Отправка запроса на получение списка новостей (CORS)", () -> {
            given(baseRequestSpec)
            .when()
                    .get("/cors/news-feed")
            .then()
                    .spec(baseResponseSpec)
                    .statusCode(200);
        });
    }

    @Test
    @Story("Получение списка заголовков новостей (CORS)")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Позитивная проверка на статус код при получении списка заголовков новостей (CORS)")
    void checkCorsNewsSectionNamesSuccessfulStatusCode(){
        step("Отправка запроса на получение списка заголовков новостей", () -> {
            given(baseRequestSpec)
            .when()
                    .get("/cors/news-section-names")
            .then()
                    .spec(baseResponseSpec)
                    .statusCode(200);
        });
    }

    @Test
    @Story("Получение списка новостей")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Позитивная проверка на статус код при получении списка новостей")
    void checkNewsFeedSuccessfulStatusCode(){
        step("Отправка запроса на получение списка новостей", () -> {
            given(baseRequestSpec)
            .when()
                    .get("/news-feed")
            .then()
                    .spec(baseResponseSpec)
                    .statusCode(200);
        });
    }

    @Test
    @Story("Получение списка новостей по определенным заголовкам")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Позитивная проверка на статус код при получении списка новостей по определенным заголовкам")
    void checkNewsSectionSuccessfulStatusCode(){
        List<String> params = List.of("Business", "Sports", "Technology");

        NewsSectionLombokModel newsSectionLombokModel = new NewsSectionLombokModel();
        newsSectionLombokModel.setSections(params);

        step("Отправка запроса на получение списка новостей по определенным заголовкам", () -> {
            given(baseRequestSpec)
                    .body(newsSectionLombokModel)
                    .when()
                    .post("/news-section")
                    .then()
                    .spec(baseResponseSpec)
                    .statusCode(200);
        });
    }

    @Test
    @Story("Получение списка заголовков новостей")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Позитивная проверка на статус код при получении списка заголовков новостей")
    void checkNewsSectionNamesSuccessfulStatusCode(){
        step("Отправка запроса на получение списка заголовков новостей", () -> {
            given(baseRequestSpec)
            .when()
                    .get("/news-section-names")
            .then()
                    .spec(baseResponseSpec)
                    .statusCode(200);
        });
    }
}
