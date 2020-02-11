package org.selenide.examples.config.configuration;

public enum EPropertiesKeys {
    BASE_URL("BASE_URL"),
    KEY_NOT_DEFINED("PROPERTY KEY NOT DEFINED"),
    ENV("ENV"),
    DEFAULT_ENV("DEV"),
    ENV_FILENAME_SUFFIX(".environment.properties");

    private final String key;

    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return getKey();
    }

    EPropertiesKeys(String selectorText) {
        this.key = selectorText;
    }
}
