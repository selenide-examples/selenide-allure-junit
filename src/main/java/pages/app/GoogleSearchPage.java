package pages.app;

import org.openqa.selenium.By;
import pages.base.BasePage;
import repositories.ESelectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class GoogleSearchPage extends BasePage {
    public GoogleSearchPage() {
        setURL("/login");
    }

    public GoogleResultsPage search(String query) {
        $(By.name(ESelectors.SELECTOR_NAME_Q.getSelectorText())).setValue(query).pressEnter();
        return page(GoogleResultsPage.class);
    }
}
