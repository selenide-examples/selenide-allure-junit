package org.selenide.examples.tests.pages;

import org.junit.Test;
import org.selenide.examples.config.pages.app.GoogleResultsPage;
import org.selenide.examples.config.pages.app.GoogleSearchPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;
import org.selenide.examples.config.tests.BaseTests;

import static com.codeborne.selenide.Selenide.open;

public class GoogleSearchTest extends BaseTests {
    @Test
    @Features("Seraches for common phrases")
    @Stories({"Google Basic Searches"})
    @Issue("JIRA-67")
    public void userCanSearchAnyKeywordAndResultsPageIsReturned() {
        GoogleSearchPage googleSearchPage = open(GoogleSearchPage.getAbsoluteUrl(), GoogleSearchPage.class);
        GoogleResultsPage googleResultsPage = googleSearchPage.search("common phrase");
    }
}
