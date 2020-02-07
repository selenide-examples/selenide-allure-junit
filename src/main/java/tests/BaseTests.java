package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit.ScreenShooter;
import com.google.common.collect.ImmutableMap;
import configuration.EnvironmentPropertiesLoader;
import org.junit.After;
import org.junit.AfterClass;
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

/**
 * Bootstrap class as BaseTests should be run before anything else once
 */
public class BaseTests {
    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests().succeededTests();
    @Rule
    public TestName name = new TestName();
    private static Logger log = Logger.getLogger("BaseTests");

    static {
        setAllureEnvironment();
        setSelenideConfiguration();
    }

    private static void setAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", Configuration.browser)
                        .put("URL", EnvironmentPropertiesLoader.getProps().getProperty("BASE_URL"))
                        .build());
    }

    private static void setSelenideConfiguration() {
        Configuration.screenshots = true;
        Configuration.savePageSource = false;
        Configuration.reportsFolder = "target/allure-results"; //write screenshot to allure with prettyName
    }


    public byte[] saveScreenshotOnDiskAndReturn() {
        try {
            screenshot(name.getMethodName());
            Path content = Paths.get("target" + System.getProperty("file.separator") + "allure-results", name.getMethodName() + ".png").toAbsolutePath();
            log.log(Level.INFO, "Screenshot being done for " + name.getMethodName());
            return Files.readAllBytes(content);

        } catch (IOException e) {
            log.log(Level.INFO, e.getStackTrace().toString());
        }
        return  null;
    }

    @After
    public void tearDown() throws IOException {
        attachScreenshot();
    }

    @Attachment(type = "image/png")
    public byte[] attachScreenshot() throws IOException {

        return saveScreenshotOnDiskAndReturn();
    }

    @AfterClass
    public static void closeBrowser() {
        //close();
    }
}
