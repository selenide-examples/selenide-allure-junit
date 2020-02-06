package org.selenide.examples.pages;

import org.junit.Test;
import pages.app.GoogleResultsPage;
import pages.app.GoogleSearchPage;

import static com.codeborne.selenide.Selenide.open;

public class GoogleSearchTest {

    @Test
    public void userCanSearchAnyKeywordAndResultsPageIsReturned() {
        GoogleSearchPage googleSearchPage = open(GoogleSearchPage.getAbsoluteUrl(), GoogleSearchPage.class);
        GoogleResultsPage googleResultsPage = googleSearchPage.search("dupa");

        System.out.println("AA: " + googleResultsPage.getAbsoluteUrl());
    }
}
