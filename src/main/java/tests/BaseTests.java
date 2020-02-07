package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.google.common.collect.ImmutableMap;
import configuration.EnvironmentPropertiesLoader;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

/**
 * Bootstrap class as BaseTests should be run before anything else once
 */
public class BaseTests {
    static {
        setAllureEnvironment();
    }

    private static void setAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", Configuration.browser)
                        .put("URL", EnvironmentPropertiesLoader.getProps().getProperty("BASE_URL"))
                        .build());
    }
}
