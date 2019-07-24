package org.selenide.examples;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.xlstest.XLS;
import com.google.common.io.Files;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.or;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.FileDownloadMode.PROXY;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertThat;

public class InternetBankTest {
  @BeforeClass
  public static void setUp() {
    close();
    Configuration.baseUrl = "https://idemo.bspb.ru";
    Configuration.proxyEnabled = true;
    Configuration.fileDownload = PROXY;
  }

  @Before
  public void login() {
    open("/");
    $(By.name("username")).val("demo");
    $(By.name("password")).val("demo").pressEnter();
    enter2ndFactor();
  }

  private void enter2ndFactor() {
    $("#otp-code-text").shouldBe(visible);
    if ($("#login-crypto-button").isDisplayed()) {
      $("#login-crypto-button").click();
    }
    else {
      $(By.name("otpCode")).val("0000").pressEnter();
    }
  }

  @Test
  public void userCanLoginToBspbDemo() {
    $("#user-greeting").shouldHave(text("Hello World!"));
  }

  @Test
  public void userCanLoadStatementForLastMonth() {
    open("/bank/overview");

    $("#accounts .account a").click();
    $(".page-header").shouldHave(text("Statement"));
    $("#defined-periods").find(byText("Beginning of last month until today")).click();
  }

  @Test
  public void userCanViewTransactionDetails() {
    openStatement();
    $(".statement-container .transaction-row.tx-debit .counterparty-name").scrollTo().click();
    $("#transaction-dialog #transaction-header").shouldHave(text("Transaction details"));
    $("#transaction-dialog #payment-beneficiary").shouldHave(text("Beneficiary"));
    $("#transaction-dialog #beneficiary-account").shouldHave(
        text("Beneficiary account"),
        text("***** *** * **** ***0000")
    );
  }

  @Test
  public void userCanDownloadStatementAsPdf() throws IOException {
    openStatement();
    $("#statement-export").click();

    File statementPdf = $("#btn-export-pdf").download();

    PDF pdf = new PDF(statementPdf);
    assertThat(pdf, PDF.containsText("ПАО \"БАНК \"САНКТ-ПЕТЕРБУРГ\""));
    assertThat(pdf, PDF.containsText("BIC 044030790"));
    assertThat(pdf, PDF.containsText("Королёва Ольга"));
    assertThat(pdf, PDF.containsText("Statement Period:"));
  }

  @Test
  public void userCanDownloadStatementAsExcel() throws IOException {
    openStatement();
    $("#statement-export").click();

    File statementExcel = $("#btn-export-xls").download();

    XLS xls = new XLS(statementExcel);
    assertThat(xls, XLS.containsText("Королёва Ольга"));
    assertThat(xls, XLS.containsText("40817810048000102279"));
    assertThat(xls, XLS.containsText("Closing balance"));
    assertThat(xls, XLS.containsText("Credit turnover"));
    assertThat(xls, XLS.containsText("Debit turnover"));
    assertThat(xls, XLS.containsText("Reserved"));
  }

  @Test
  public void userCanAssignAliasForAccount() {
    open("/bank/overview");
    SelenideElement account = $("#accounts .account", 2).scrollTo();

    account.find("a.alias")
        .shouldHave(or("account or alias", text("50817 810 0 4800 0104467"), text("Это типа счёт"))
            .because("the alias could already be changed by previous test run"))
        .hover();
    
    account.find(".icon-edit").should(appear).click();
    account.find(By.name("alias")).val("Это типа счёт").pressEnter();
    
    account.shouldHave(text("Это типа счёт"));
    
    account.shouldNotHave(text("50817 810 0 4800 0104467"));
  }

  private void openStatement() {
    open("/statement");
    $("#defined-periods").find(byText("Beginning of last month until today")).click();
  }

  @After
  public void tearDown() throws IOException {
    screenshot();
  }

  @Attachment(type = "image/png")
  public byte[] screenshot() throws IOException {
    File screenshot = Screenshots.getLastScreenshot();
    return screenshot == null ? null : Files.toByteArray(screenshot);
  }
}
