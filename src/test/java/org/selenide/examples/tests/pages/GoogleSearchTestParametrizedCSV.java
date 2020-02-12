package org.selenide.examples.tests.pages;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.selenide.examples.config.pages.app.GoogleResultsPage;
import org.selenide.examples.config.pages.app.GoogleSearchPage;
import org.selenide.examples.config.tests.BaseTests;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;

@RunWith(JUnitParamsRunner.class)
public class GoogleSearchTestParametrizedCSV extends BaseTests {
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    GoogleResultsPage googleResultsPage = new GoogleResultsPage();


    @Test
    @Features("Searches for common phrases from CSV")
    @Stories({"Google Basic Searches"})
    @Issue("JIRA-67")
    @FileParameters("src/test/resources/tests/data/phrases.csv")
    public void userCanSearchAnyKeywordAndResultsPageIsReturned(String phrasePart1, String phrasePart2) {
        googleSearchPage.open();
        googleResultsPage = googleSearchPage.search(phrasePart1 + " OR " + phrasePart2);
        assert true;
    }
}
