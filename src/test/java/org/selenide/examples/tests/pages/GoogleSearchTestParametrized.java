package org.selenide.examples.tests.pages;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.selenide.examples.config.pages.app.GoogleResultsPage;
import org.selenide.examples.config.pages.app.GoogleSearchPage;
import org.selenide.examples.config.tests.BaseTests;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Issue;
import ru.yandex.qatools.allure.annotations.Stories;

@RunWith(Parameterized.class)
public class GoogleSearchTestParametrized extends BaseTests {
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    GoogleResultsPage googleResultsPage = new GoogleResultsPage();

    @Parameters
    public static Object[] data() {
        return new Object[]{"Common phrase 1", "Common phrase 2", "Common phrase3"};
    }

    @Parameter
    public String commomnSearchPhrase;

    @Test
    @Features("Searches for common phrases")
    @Stories({"Google Basic Searches"})
    @Issue("JIRA-67")
    public void userCanSearchAnyKeywordAndResultsPageIsReturned() {
        googleSearchPage.open();
        googleResultsPage = googleSearchPage.search(commomnSearchPhrase);
        assert true;
    }
}
