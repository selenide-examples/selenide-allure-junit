package org.selenide.examples.config.pages.app;

import org.openqa.selenium.By;
import org.selenide.examples.config.pages.base.BasePage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class GoogleSearchPage extends BasePage {
    public GoogleSearchPage() {
        super("/");
    }

    public GoogleResultsPage search(String query) {
        $(By.name("q")).setValue(query).pressEnter();
        return page(GoogleResultsPage.class);
    }
}
