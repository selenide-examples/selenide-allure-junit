package org.selenide.examples.config.pages.base;

public interface IBasePage {
    void setBaseUrl(String baseUrl);

    String getBaseUrl();

    String getAbsoluteUrl();

    String getURL();

    void setURL(String url);
    BasePage open();
}
