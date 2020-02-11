package org.selenide.examples.tests.pages;

import org.junit.Test;
import org.selenide.examples.config.pages.app.GoogleResultsPage;
import org.selenide.examples.config.pages.app.GoogleSearchPage;
import org.selenide.examples.config.tests.BaseTests;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;

public class GoogleSearchTest extends BaseTests {
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    GoogleResultsPage googleResultsPage = new GoogleResultsPage();

    @Test
    @Features("Searches for common phrases")
    @Stories({"Google Basic Searches"})
    @Issue("JIRA-67")
    public void userCanSearchAnyKeywordAndResultsPageIsReturned() {
        googleSearchPage.open();
        googleResultsPage = googleSearchPage.search("common phrase");
        assert true;
    }
}
