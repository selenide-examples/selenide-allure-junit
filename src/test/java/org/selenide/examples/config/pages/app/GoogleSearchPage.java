package org.selenide.examples.config.pages.app;

import org.openqa.selenium.By;
import org.selenide.examples.config.pages.base.BasePage;

import static com.codeborne.selenide.Selenide.$;

/**
 * POMS after https://github.com/yashaka/talks/tree/master/kiss-pageobjects
 */
public class GoogleSearchPage extends BasePage {
    public GoogleSearchPage() {
        super("/");
    }

    @Override
    public GoogleSearchPage open() {
        super.open();
        return this;
    }

    public GoogleResultsPage search(String query) {
        $(By.name("q")).setValue(query).pressEnter();
        return new GoogleResultsPage();
    }
}
