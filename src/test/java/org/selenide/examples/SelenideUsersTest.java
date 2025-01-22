package org.selenide.examples;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.junit5.TextReportExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.sizeLessThan;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

@ExtendWith(TextReportExtension.class)
class SelenideUsersTest {

  @BeforeEach
  public void setUp() {
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    open();
  }

  @Test
  void showsAllUsersCategories() {
    open("https://selenide.org/users.html");
    $$("#user-tags .tag").first(5)
      .shouldHave(texts("usa", "europe", "asia", "estonia", "ukraine"));
  }

  @ParameterizedTest(name = "#{index}. Let's search [{argumentsWithNames}]")
  @ValueSource(strings = {"usa", "ukraine", "europe", "estonia"})
  void userCanSearchAnyKeyword(String tag) {
    open("https://selenide.org");
    $(".main-menu-pages").find(byText("Users")).click();
    ElementsCollection users = $$("#selenide-users .user:not(.hidden)");
    users.shouldHave(size(1));
    $("#user-tags .reset-filter").shouldHave(text("all")).click();
    users.shouldHave(sizeGreaterThan(50));

    $$("#user-tags .tag")
      .shouldHave(sizeGreaterThan(7))
      .findBy(text(tag))
      .click();

    users.shouldHave(size($$("#selenide-users ." + tag).size()), Duration.ofSeconds(10));
    users.filterBy(not(cssClass(tag))).shouldHave(size(0));
    users.shouldHave(sizeGreaterThan(5));
    users.shouldHave(sizeLessThan(50));
  }
}
