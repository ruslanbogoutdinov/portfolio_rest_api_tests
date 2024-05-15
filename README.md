# Демо-проект по автоматизации тестирования API сайта [ok.surf](https://ok.surf/)

<p align="center">
  <img title="OKSurf" src="src/test/resources/media/screenshots/OKSurf.png" alt="OKSurf">
</p>

## Содержание

* <a href="#cases">Реализованные проверки</a>

* <a href="#console">Запуск тестов из терминала</a>

* <a href="#jenkins">Запуск тестов в Jenkins</a>

* <a href="#allure">Отчет в Allure Report</a>

* <a href="#allure-testops">Интеграция с Allure TestOps</a>

* <a href="#telegram">Telegram уведомление</a>

<a id="cases"></a>
## Реализованные проверки

- [x] Позитивная проверка на статус код при получении списка новостей (CORS)
- [x] Позитивная проверка на статус код при получении списка новостей
- [x] Позитивная проверка на статус код при получении списка заголовков новостей (CORS)
- [x] Позитивная проверка на статус код при получении списка заголовков новостей
- [x] Позитивная проверка на статус код при получении списка новостей по определенным заголовкам
- [x] Негативная проверка на статус код при получении списка новостей (CORS)
- [x] Негативная проверка на статус код при получении списка новостей
- [x] Негативная проверка на статус код при получении списка заголовков новостей
- [x] Проверка параметра 'link' у запроса на получение списка новостей (CORS)
- [x] Проверка параметра 'title' у запроса на получение списка новостей
- [x] Проверка на JSON схему для заголовков новостей (CORS)
- [x] Проверка на JSON схему для заголовков новостей

<a id="console"></a>
## Запуск тестов из терминала

```bash
gradle clean test
```
<a id="jenkins"></a>
## <img src="src/test/resources/media/logos/Jenkins.svg" alt="Jenkins" width="25" height="25"/> Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/portfolio_api_tests/)

#### Главная страница Jenkins

<p align="center">
  <img title="Jenkins" src="src/test/resources/media/screenshots/Jenkins.png" alt="Jenkins" width="800">
</p>

> Для запуска сборки необходимо нажать <code><strong>*Build Now*</strong></code>.

<a id="allure_report_and_allure_testops"></a>
#### Значки Allure Report и Allure TestOps

<p align="center">
  <img title="AllureButtons" src="src/test/resources/media/screenshots/AllureButtons.png" alt="AllureButtons" width="800">
</p>

> Клик по иконкам <code><strong>*Allure TestOps*</strong></code> и <code><strong>*Allure Report*</strong></code> позволяет перейти
> на просмотр страниц с тестовой документацией и отчетов.

<a id="allure"></a>
## <img src="src/test/resources/media/logos/AllureReport.svg" alt="Allure Report" width="25" height="25"/></a> Отчет в [Allure Report](https://jenkins.autotests.cloud/job/portfolio_api_tests/allure/)

#### Главная страница Allure Report

<p align="center">
  <img title="Allure Report overview" src="src/test/resources/media/screenshots/AllureReportMain.png" alt="Allure Report overview" width="800">
</p>

#### Тесты

<p align="center">
  <img title="Allure Report tests" src="src/test/resources/media/screenshots/AllureTests.png" alt="Allure Report tests" width="800">
</p>

#### Графики

<p align="center">
  <img title="Allure Report graphs" src="src/test/resources/media/screenshots/AllureGraphs.png" alt="Allure Report graphs" width="800">
</p>

<a id="allure-testops"></a>
## <img src="src/test/resources/media/logos/AllureTestOps.svg" width="25" height="25"/></a> Интеграция с [Allure TestOps](https://allure.autotests.cloud/launch/39052)

#### Тест-кейсы

<p align="center">
  <img title="Allure TestOps tests" src="src/test/resources/media/screenshots/AllureTestOpsTests.png" alt="Allure TestOps tests" width="800">
</p>

#### Дашборды

<p align="center">
  <img title="Allure TestOps dashboards" src="src/test/resources/media/screenshots/AllureTestOpsDashboards.png" alt="Allure TestOps dashboards" width="800">
</p>

<a id="telegram"></a>
## <img src="src/test/resources/media/logos/Telegram.svg" width="25" height="25"/></a> Telegram уведомление

#### Оповещение о результатах сборки

<p align="center">
  <img title="Telegram" src="src/test/resources/media/screenshots/Telegram.png" alt="Telegram" width="800">
</p>