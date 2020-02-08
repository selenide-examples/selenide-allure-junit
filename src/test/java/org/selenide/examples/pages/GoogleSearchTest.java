package org.selenide.examples.pages;

import io.qameta.allure.Feature;
import io.qameta.allure.Issues;
import org.junit.Test;
import pages.app.GoogleResultsPage;
import pages.app.GoogleSearchPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Stories;
import tests.BaseTests;

import static com.codeborne.selenide.Selenide.open;

public class GoogleSearchTest extends BaseTests {
    @Test
    @Features("A")
    @Stories({"A"})
    @Issue("JIRA-67")
    public void userCanSearchAnyKeywordAndResultsPageIsReturned() {
        GoogleSearchPage googleSearchPage = open(GoogleSearchPage.getAbsoluteUrl(), GoogleSearchPage.class);
        GoogleResultsPage googleResultsPage = googleSearchPage.search("common phrase");
        assert false;
    }
}
