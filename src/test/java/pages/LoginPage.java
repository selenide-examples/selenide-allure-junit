package pages;

import com.codeborne.selenide.Selenide;
import common.BasePage;
import utils.config.ConfigProvider;
import utils.dto.LoginUserDto;
import utils.enums.Users;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static utils.config.ConfigProvider.getLogin;
import static utils.config.ConfigProvider.getPassword;

public class LoginPage extends BasePage {
  private static final String LOGIN_FIELD_XPATH = "//input[@name='login']";
  private static final String PASSWORD_FIELD_XPATH = "//input[@name='password']";
  private static final String LOGIN_BUTTON_XPATH = "//button[@type='submit']";

  public LoginPage() {
  }

  public void openLoginPage() {
    Selenide.open(ConfigProvider.URL);
  }

  public void loginWithUser(Users userRole) {
    LoginUserDto user = getUser(userRole.getName());

    $x(LOGIN_FIELD_XPATH).shouldBe(visible, enabled)
      .setValue(user.getUserName());
    $x(PASSWORD_FIELD_XPATH).shouldBe(visible, enabled)
      .setValue(user.getUserPassword());
    $x(LOGIN_BUTTON_XPATH).shouldBe(visible, enabled)
      .click();
  }

  private LoginUserDto getUser(String userRole) {
    return new LoginUserDto(getLogin(userRole), getPassword(userRole));
  }
}
