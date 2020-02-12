package org.selenide.examples.config.pages.base;

import com.codeborne.selenide.Selenide;

public interface IBasePage {
    void setBaseUrl(String baseUrl);

    String getBaseUrl();

    String getAbsoluteUrl();

    String getURL();

    void setURL(String url);
    void open();
}
