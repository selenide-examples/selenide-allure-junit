package pages;

import common.BasePage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage extends BasePage {
    private static final String HOME_PAGE_TITLE_XPATH = "//span[@title = 'All Dashboards']";

    public void dashboardsPageShouldBeOpened() {
        $x(HOME_PAGE_TITLE_XPATH).shouldBe(visible, Duration.ofMillis(10000));
    }
}
