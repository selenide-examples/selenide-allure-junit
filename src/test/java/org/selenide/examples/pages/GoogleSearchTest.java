package org.selenide.examples.pages;

import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import org.junit.After;
import org.junit.Test;
import pages.app.GoogleResultsPage;
import pages.app.GoogleSearchPage;
import ru.yandex.qatools.allure.annotations.Attachment;
import tests.BaseTests;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class GoogleSearchTest extends BaseTests {

    @Test
    public void userCanSearchAnyKeywordAndResultsPageIsReturned() {
        GoogleSearchPage googleSearchPage = open(GoogleSearchPage.getAbsoluteUrl(), GoogleSearchPage.class);
        GoogleResultsPage googleResultsPage = googleSearchPage.search("dupa");

        System.out.println("AA: " + googleResultsPage.getAbsoluteUrl());
    }
}
