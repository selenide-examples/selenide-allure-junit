package org.selenide.examples;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.SelenideElement;
import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertTrue;

public class InternetBankTest {
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

//    random data, cannot test regularly :(
//    $$("#statement-2 .transaction-row").shouldHave(size(71));
//    $("#statement-2 .transaction-row").shouldHave(
//        text("Лукойл"),
//        text("83151810351541100000"),
//        text("Заправка бензина 95Е, 40 л."),
//        text("+3.00"),
//        text("-256.00")
//    );
  }

  @Test
  public void userCanViewTransactionDetails() {
    openStatement();
    $("#statement-2 .transaction-row a").click();
    $("#transaction-dialog #transaction-header").shouldHave(text("Transaction details"));
    $("#transaction-dialog #payment-beneficiary").shouldHave(text("Beneficiary"));
    $("#transaction-dialog #payment-beneficiary-account").shouldHave(
        text("Beneficiary account"), text("83151 810 3 5154 1100000"));
  }

  @Test
  public void userCanDownloadStatementAsPdf() throws IOException {
    openStatement();
    File statementPdf = $("#btn-export-pdf").download();
    assertTrue(FileUtils.readFileToString(statementPdf).startsWith("%PDF"));
    // verify PDF content
  }

  @Test
  public void userCanAssignAliasForAccount() {
    open("http://idemo.bspb.ru/security/fakeLogin?username=demo&url=/bank/overview");
    SelenideElement account = $(".account#account-1");
    
    account.find("a.alias")
        .shouldHave(text("40817 810 0 4800 0102279"))
        .hover();
    
    account.find(".icon-edit").should(appear).click();
    account.find(By.name("alias")).val("Это типа счёт").pressEnter();
    
    account.shouldHave(text("Это типа счёт"));
    
    account.shouldNotHave(text("40817 810 0 4800 0102279"));
  }

  private void openStatement() {
    open("http://idemo.bspb.ru/security/fakeLogin?username=demo&url=/statement");
    $("#defined-periods").find(byText("Beginning of last month until today")).click();
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
