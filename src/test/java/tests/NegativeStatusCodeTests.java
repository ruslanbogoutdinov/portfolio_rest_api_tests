package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.annotations.Layer;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static specs.BaseSpec.baseRequestSpec;
import static specs.BaseSpec.baseResponseSpec;

@Layer("rest api")
@Feature("Негативные тесты на статус код")
@Owner("Ruslan Bogoutdinov")
public class NegativeStatusCodeTests {
    @Test
    @Story("Получение списка новостей (CORS)")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Негативная проверка на статус код при получении списка новостей (CORS)")
    void checkCorsNewsFeedNegativeStatusCode(){
        step("Отправка запроса на получение списка новостей (CORS)", () -> {
            given(baseRequestSpec)
            .when()
                    .get("https://ok.surf/api/v1/cors/news-feed")
            .then()
                    .spec(baseResponseSpec)
                    .statusCode(400);
        });
    }

    @Test
    @Story("Получение списка заголовков новостей (CORS)")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Негативная проверка на статус код при получении списка заголовков новостей")
    void checkCorsNewsSectionNamesNegativeStatusCode(){
        step("Отправка запроса на получение списка заголовков новостей", () -> {
            given(baseRequestSpec)
            .when()
                    .get("https://ok.surf/api/v1/cors/news-section-names")
            .then()
                    .spec(baseResponseSpec)
                    .statusCode(400);
        });
    }

    @Test
    @Story("Получение списка новостей")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Негативная проверка на статус код при получении списка новостей")
    void checkNewsFeedNegativeStatusCode(){
        step("Отправка запроса на получение списка новостей", () ->{
            given(baseRequestSpec)
            .when()
                    .get("https://ok.surf/api/v1/news-feed")
            .then()
                    .spec(baseResponseSpec)
                    .statusCode(400);
        });
    }
}
