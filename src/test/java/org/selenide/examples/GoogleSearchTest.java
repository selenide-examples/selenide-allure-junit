package org.selenide.examples;

import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GoogleSearchTest {
  @Test
  public void userCanSearchAnyKeyword() {
    open("http://google.com/en");
    $(By.name("q")).val("selenide").pressEnter();
    $$("#ires li.g").shouldHave(size(10));
    $("#ires li.g").shouldHave(text("selenide.org"));
  }
}
