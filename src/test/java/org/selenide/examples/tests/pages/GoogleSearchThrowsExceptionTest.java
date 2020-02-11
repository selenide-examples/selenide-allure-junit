package org.selenide.examples.tests.pages;

import io.qameta.allure.Flaky;
import org.junit.Test;
import org.selenide.examples.config.pages.app.GoogleResultsPage;
import org.selenide.examples.config.pages.app.GoogleSearchPage;
import org.selenide.examples.config.tests.BaseTests;

import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.open;

public class GoogleSearchThrowsExceptionTest extends BaseTests {
    @Test
    public void userCanSearchAnyKeywordThenResultsPageIsReturnedThenExceptionThrown() throws FileNotFoundException {
        GoogleSearchPage googleSearchPage = open(GoogleSearchPage.getAbsoluteUrl(), GoogleSearchPage.class);
        GoogleResultsPage googleResultsPage = googleSearchPage.search("Uncommon phrase");
        throw new FileNotFoundException();

    }
}
