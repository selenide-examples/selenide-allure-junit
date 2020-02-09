package org.selenide.examples.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.selenide.examples.pages.GoogleSearchTest;
import org.selenide.examples.pages.PagesTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        GoogleSearchTest.class,
        PagesTest.class
})

public class AllSuite {
}
