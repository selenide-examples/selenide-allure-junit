package org.selenide.examples.tests.pages;

import org.junit.Test;
import org.selenide.examples.config.pages.app.GoogleResultsPage;
import org.selenide.examples.config.pages.app.GoogleSearchPage;
import org.selenide.examples.config.tests.BaseTests;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;

public class GoogleSearchAssertFailsTest extends BaseTests {
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    GoogleResultsPage googleResultsPage = new GoogleResultsPage();

    @Test
    public void userCanSearchAnyKeywordThenResultsPageIsReturnedThenAssertFails() {
        final int EXPECTED_MINIMUM_SIZE = 9999;
        googleSearchPage.open();
        googleResultsPage = googleSearchPage.search("Uncommon phrase");
        googleResultsPage.getResults().shouldHave(sizeGreaterThan(EXPECTED_MINIMUM_SIZE));
    }
}
