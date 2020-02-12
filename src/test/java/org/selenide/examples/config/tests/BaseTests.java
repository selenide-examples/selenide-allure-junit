package org.selenide.examples.config.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.ScreenShooter;
import com.google.common.collect.ImmutableMap;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.codeborne.selenide.Selenide.screenshot;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import static org.selenide.examples.config.configuration.EnvironmentPropertiesLoader.getEnvProps;

/**
 * Bootstrap class as BaseTests should be run before anything else once
 */
public class BaseTests {
    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests().succeededTests();
    @Rule
    public TestName name = new TestName();
    private static final String BASE_LOGGER_NAME = "Base Tests";
    private static Logger log = Logger.getLogger(BASE_LOGGER_NAME);
    private static final String REPORT_DIR = "target" + System.getProperty("file.separator") + "allure-results";//move to properties one day

    static {
        setAllureEnvironment();
        setSelenideConfiguration();
    }

    private static void setAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", Configuration.browser)
                        .put("Base URL:", getEnvProps().getProperty("base.url", "unknown URL"))
                        .put("Tests:", System.getProperty("test", "All tests have been run"))
                        .build()
        );

    }

    private static void setSelenideConfiguration() {
        Configuration.screenshots = true;
        Configuration.savePageSource = false;
        Configuration.reportsFolder = REPORT_DIR; //write screenshot to allure with prettyName
    }


    /**
     * Allows to save additonal screenshot with nice mnemonical names
     *
     * @return screenshot file
     */
    public byte[] saveScreenshotOnDiskAndReturn() {
        try {
            screenshot(name.getMethodName());
            Path content = Paths.get(REPORT_DIR, name.getMethodName() + ".png").toAbsolutePath();
            log.log(Level.INFO, "Screenshot being done for " + name.getMethodName());
            return Files.readAllBytes(content);

        } catch (IOException e) {
            log.log(Level.INFO, "Cannot take screenshot: " + e.getStackTrace().toString());
        }
        return null;
    }

    @After
    public void tearDown() throws IOException {
        attachScreenshot();
    }

    @Attachment(type = "image/png", value = "lastPageScreenshot")
    public byte[] attachScreenshot() throws IOException {
        return saveScreenshotOnDiskAndReturn();
    }
}
