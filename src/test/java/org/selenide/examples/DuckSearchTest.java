package org.selenide.examples;

import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

@ExtendWith(TextReportExtension.class)
class DuckSearchTest {

  @BeforeEach
  public void setUp() {
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
  }

  @Test
  void userCanSearchAnyKeyword() {
    open("https://duckduckgo.com/");
    $(By.name("q")).val("selenide").pressEnter();
    $$(".js-results").shouldHave(size(1));
    $$(".js-results .result").shouldHave(sizeGreaterThan(5));
    $(".js-results .result").shouldHave(text("selenide.org"));
  }
}
