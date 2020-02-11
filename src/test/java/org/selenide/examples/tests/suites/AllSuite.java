package org.selenide.examples.tests.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.selenide.examples.tests.pages.GoogleSearchTest;
import org.selenide.examples.tests.pages.PagesTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        GoogleSearchTest.class,
        PagesTest.class
})

public class AllSuite {
}
