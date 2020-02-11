package org.selenide.examples.tests.pages;

import org.junit.Test;
import org.selenide.examples.config.pages.app.GoogleResultsPage;

public class PagesTest {
    @Test
    public void absoluteUrlIsCorrectlyBuilt() {
        assert GoogleResultsPage.getAbsoluteUrl().contains(GoogleResultsPage.getURL());
    }
}
