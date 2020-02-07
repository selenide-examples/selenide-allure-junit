package org.selenide.examples.pages;

import org.junit.Test;
import pages.app.GoogleResultsPage;
import pages.app.GoogleSearchPage;
import tests.BaseTests;

import static com.codeborne.selenide.Selenide.open;

public class GoogleSearchTest extends BaseTests {
    @Test
    public void userCanSearchAnyKeywordAndResultsPageIsReturned() {
        GoogleSearchPage googleSearchPage = open(GoogleSearchPage.getAbsoluteUrl(), GoogleSearchPage.class);
        GoogleResultsPage googleResultsPage = googleSearchPage.search("dupa");
    }
}
