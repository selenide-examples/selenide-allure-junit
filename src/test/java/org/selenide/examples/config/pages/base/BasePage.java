package org.selenide.examples.config.pages.base;

import org.selenide.examples.config.configuration.EPropertiesKeys;
import org.selenide.examples.config.configuration.EnvironmentPropertiesLoader;

import java.util.Properties;

public class BasePage implements IPage {
    private static String URL = "/";
    public static Properties environmentProperties;
    private static String BASE_URL;

    static {
        environmentProperties = EnvironmentPropertiesLoader.getProps();
        BASE_URL = environmentProperties.getProperty(EPropertiesKeys.BASE_URL.getKey(), EPropertiesKeys.KEY_NOT_DEFINED.getKey());
        URL = "/";
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }

    public static String getAbsoluteUrl() {
        return BASE_URL + URL;
    }

    private static void setBaseUrl(String baseUrl) {
        BASE_URL = baseUrl;
    }

    public static String getURL() {
        return URL;
    }

    public static void setURL(String url) {
        URL = url;
    }

}
