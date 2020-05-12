package org.selenide.examples;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class GoogleSearchTest {
  @Before
  public void setUp() {
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
  }

  @Test
  public void userCanSearchAnyKeyword() {
    open("https://google.com/ncr");
    $(By.name("q")).val("selenide").pressEnter();
    $$("#res .g").shouldHave(sizeGreaterThan(5));
    $("#res .g").shouldHave(text("selenide.org"));
  }
}
