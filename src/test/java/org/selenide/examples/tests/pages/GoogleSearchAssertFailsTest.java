package org.selenide.examples.tests.pages;

import org.junit.Test;
import org.selenide.examples.config.pages.app.GoogleResultsPage;
import org.selenide.examples.config.pages.app.GoogleSearchPage;
import org.selenide.examples.config.tests.BaseTests;

import static com.codeborne.selenide.Selenide.open;

public class GoogleSearchAssertFailsTest extends BaseTests {
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    GoogleResultsPage googleResultsPage = new GoogleResultsPage();

    @Test
    public void userCanSearchAnyKeywordThenResultsPageIsReturnedThenAssertFails() {
        googleSearchPage.open();
        GoogleResultsPage googleResultsPage = googleSearchPage.search("Uncommon phrase");
        googleResultsPage.getResults().shouldHaveSize(9999);
    }
}
