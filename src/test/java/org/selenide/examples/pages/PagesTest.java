package org.selenide.examples.pages;

import org.junit.Test;
import pages.app.GoogleResultsPage;

import static com.codeborne.selenide.Selenide.open;

public class PagesTest {

    @Test
    public void absoluteUrlIsCorrectkyBuilt() {
        assert GoogleResultsPage.getAbsoluteUrl().contains(GoogleResultsPage.getURL());
    }
}
