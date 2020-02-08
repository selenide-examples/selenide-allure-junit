package org.selenide.examples.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.selenide.examples.pages.GoogleSearchTest2_;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        GoogleSearchTest2_.class
})

public class SubSuite {
}
