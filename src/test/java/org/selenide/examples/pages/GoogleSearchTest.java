package org.selenide.examples.pages;

import org.junit.After;
import org.junit.Test;
import pages.app.GoogleResultsPage;
import pages.app.GoogleSearchPage;
import ru.yandex.qatools.allure.annotations.Attachment;
import tests.BaseTests;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class GoogleSearchTest extends BaseTests {


    @Test
    public void userCanSearchAnyKeywordAndResultsPageIsReturned() {
        GoogleSearchPage googleSearchPage = open(GoogleSearchPage.getAbsoluteUrl(), GoogleSearchPage.class);
        GoogleResultsPage googleResultsPage = googleSearchPage.search("dupa");
    }

    @After
    public void tearDown() throws IOException {
        screenshot();
    }

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {

        return saveScreenshotOnDiskAndReturn();
    }
}
