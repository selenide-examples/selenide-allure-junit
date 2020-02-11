package org.selenide.examples.tests.pages;

import org.junit.Test;
import org.selenide.examples.config.pages.app.GoogleResultsPage;

public class PagesTest {
    GoogleResultsPage googleResultsPage = new GoogleResultsPage();

    @Test
    public void absoluteUrlIsCorrectlyBuilt() {
        assert googleResultsPage.getAbsoluteUrl().contains(googleResultsPage.getURL());
    }
}
