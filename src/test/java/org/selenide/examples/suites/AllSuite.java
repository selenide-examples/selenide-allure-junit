package org.selenide.examples.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.selenide.examples.pages.GoogleSearchTest_;
import org.selenide.examples.pages.PagesTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        GoogleSearchTest_.class,
        PagesTest.class
})

public class AllSuite {
}
