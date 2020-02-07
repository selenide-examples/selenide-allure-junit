package org.selenide.examples.pages;

import org.junit.Test;
import pages.app.GoogleResultsPage;
import tests.BaseTests;

public class PagesTest extends BaseTests {

    @Test
    public void absoluteUrlIsCorrectlyBuilt() {
        assert GoogleResultsPage.getAbsoluteUrl().contains(GoogleResultsPage.getURL());
    }
}
