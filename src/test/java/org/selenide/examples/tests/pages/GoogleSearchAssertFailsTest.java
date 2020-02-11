package org.selenide.examples.tests.pages;

import org.junit.Assert;
import org.junit.Test;
import org.selenide.examples.config.pages.app.GoogleResultsPage;
import org.selenide.examples.config.pages.app.GoogleSearchPage;
import org.selenide.examples.config.tests.BaseTests;

import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.open;

public class GoogleSearchAssertFailsTest extends BaseTests {
    @Test
    public void userCanSearchAnyKeywordThenResultsPageIsReturnedThenAssertFails() {
        GoogleSearchPage googleSearchPage = open(GoogleSearchPage.getAbsoluteUrl(), GoogleSearchPage.class);
        GoogleResultsPage googleResultsPage = googleSearchPage.search("Uncommon phrase");
        googleResultsPage.getResults().shouldHaveSize(9999);
    }
}
