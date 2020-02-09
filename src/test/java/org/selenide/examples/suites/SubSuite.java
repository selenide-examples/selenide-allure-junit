package org.selenide.examples.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.selenide.examples.pages.GoogleSearchTest2;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        GoogleSearchTest2.class
})

public class SubSuite {
}
