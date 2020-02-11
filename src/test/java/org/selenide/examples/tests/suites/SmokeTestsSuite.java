package org.selenide.examples.tests.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.selenide.examples.tests.pages.GoogleSearchThrowsExceptionTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        GoogleSearchThrowsExceptionTest.class
})

public class SmokeTestsSuite {
}
