package common;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


abstract public class BaseTest {

    /**
     * Выполнение метода перед каждым запуском тестов
     */
    @BeforeEach
    public void init() {
        setUp();
    }

    /**
     * Инициализация selenide с настройками
     */
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.webdriverLogsEnabled = true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    /**
     * Выполнение метода после каждого закрытия тестов
     */
    @AfterEach
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.closeWebDriver();
    }
}
