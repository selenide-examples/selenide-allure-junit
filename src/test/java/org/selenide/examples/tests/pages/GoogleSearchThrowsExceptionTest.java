package org.selenide.examples.tests.pages;

import org.junit.Test;
import org.selenide.examples.config.pages.app.GoogleResultsPage;
import org.selenide.examples.config.pages.app.GoogleSearchPage;
import org.selenide.examples.config.tests.BaseTests;

import java.io.FileNotFoundException;

public class GoogleSearchThrowsExceptionTest extends BaseTests {
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    GoogleResultsPage googleResultsPage = new GoogleResultsPage();

    @Test
    public void userCanSearchAnyKeywordThenResultsPageIsReturnedThenExceptionThrown() throws FileNotFoundException {
        googleSearchPage.open();
        googleResultsPage = googleSearchPage.search("Uncommon phrase");
        throw new FileNotFoundException();
    }
}
