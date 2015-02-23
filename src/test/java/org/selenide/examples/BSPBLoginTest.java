package org.selenide.examples;

import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BSPBLoginTest {
  @Test
  public void userCanLoginToBspbDemo() {
    open("http://idemo.bspb.ru/");
    $(By.name("username")).val("demo");
    $(By.name("password")).val("demo").pressEnter();
    $(By.name("otpCode")).val("0000").pressEnter();

    $("#user-greeting").shouldHave(text("Ольга Королёва"));
    $(".page-header").shouldHave(text("Overview"));
  }

  @Test
  public void userCanLoadStatementForLastMonth() {
    open("http://idemo.bspb.ru/security/fakeLogin?username=demo&url=/bank/overview");
    
    $("#account-2 a").click();
    $(".page-header").shouldHave(text("Statement"));
    $("#defined-periods").find(byText("Beginning of last month until today")).click();
    
    $$("#statement-2 .transaction-row").shouldHave(size(71));
    $("#statement-2 .transaction-row").shouldHave(
        text("Лукойл"),
        text("83151810351541100000"),
        text("Заправка бензина 95Е, 40 л."),
        text("+3.00"),
        text("-256.00")
    );
  }

  @After
  public void tearDown() throws IOException {
    screenshot();
  }

  @Attachment(type = "image/png")
  public byte[] screenshot() throws IOException {
    File screenshot = Screenshots.getScreenShotAsFile();
    return Files.toByteArray(screenshot);
  }
}
