package org.selenide.examples.tests.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.selenide.examples.tests.pages.GoogleSearchAssertFailsTest;
import org.selenide.examples.tests.pages.GoogleSearchTestParametrized;
import org.selenide.examples.tests.pages.PagesTest;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        GoogleSearchTestParametrized.class,
        GoogleSearchAssertFailsTest.class,
        PagesTest.class,

})

public class RegressionTestsSuite {
}
