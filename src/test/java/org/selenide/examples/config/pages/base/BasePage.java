package org.selenide.examples.config.pages.base;

import com.codeborne.selenide.Selenide;
import org.selenide.examples.config.configuration.EPropertiesKeys;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.selenide.examples.config.configuration.EnvironmentPropertiesLoader.getEnvProps;

public class BasePage implements IBasePage {
    protected String URL = "/";
    protected String BASE_URL;
    private static Logger log = Logger.getLogger(BasePage.class.getName());

    public BasePage() {
        this("/");
    }

    public BasePage(String url) {
        this(url, getEnvProps().getProperty(EPropertiesKeys.BASE_URL.getKey()));
    }

    public BasePage(String URL, String BASE_URL) {
        this.URL = URL;
        this.BASE_URL = BASE_URL;
    }


    @Override
    public void setBaseUrl(String baseUrl) {
        this.BASE_URL = baseUrl;
    }

    @Override
    public String getBaseUrl() {
        return this.BASE_URL;
    }

    @Override
    public String getAbsoluteUrl() {
        return this.BASE_URL + this.URL;
    }

    @Override
    public String getURL() {
        return this.URL;
    }

    @Override
    public void setURL(String url) {
        this.URL = url;
    }

    @Override
    public void open() {
        log.log(Level.INFO, "Accessing :" + this.getClass().getSimpleName() + " @ URL: " + getAbsoluteUrl());
        Selenide.open(this.getAbsoluteUrl());
    }
}
