package tests;

import common.BaseTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import pages.DashboardPage;
import pages.LoginPage;

import static utils.enums.Users.ADMINISTRATOR;

public class LoginTest extends BaseTest {
  LoginPage login = new LoginPage();
  DashboardPage dashboardPage = new DashboardPage();

  @Test
  @Description("Admin user is able to login to Report portal")
  void openLoginPageAsAdmin() {
    login.openLoginPage();
    login.loginWithUser(ADMINISTRATOR);
    dashboardPage.dashboardsPageShouldBeOpened();
  }
}
