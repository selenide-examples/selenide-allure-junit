package org.selenide.examples.tests.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.selenide.examples.tests.pages.GoogleSearchTestParametrized;
import org.selenide.examples.tests.pages.GoogleSearchThrowsExceptionTest;
import org.selenide.examples.tests.pages.PagesTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        GoogleSearchThrowsExceptionTest.class,
        PagesTest.class,
        GoogleSearchTestParametrized.class
})

public class SmokeTestsSuite {
}
