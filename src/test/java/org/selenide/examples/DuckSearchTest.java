package org.selenide.examples;

import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.SetValueOptions.withText;

@ExtendWith(TextReportExtension.class)
class DuckSearchTest {

  @BeforeEach
  public void setUp() {
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
  }

  @ParameterizedTest(name = "#{index}. Let's search {0}")
  @ValueSource(strings = {"Selenide", "Codeborne", "Solntsev", "Tallinn"})
  void userCanSearchAnyKeyword(String query) {
    open("https://duckduckgo.com/");
    $(By.name("q")).setValue(withText(query).sensitive()).pressEnter();
    $$(".js-results").shouldHave(size(1));
    $$(".js-results [data-testid=\"result\"]").shouldHave(sizeGreaterThan(5));
    $(".js-results [data-testid=\"result\"]").shouldHave(text(query));
  }
}
