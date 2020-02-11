package org.selenide.examples.config.configuration;

public enum EPropertiesKeys {
    BASE_URL("base.url"),
    KEY_NOT_DEFINED("PROPERTY KEY NOT DEFINED"),
    ENV("env"),
    DEFAULT_ENV("dev"),
    ENV_FILENAME_SUFFIX(".environment.properties");

    private final String key;

    public String getKey() {
        return key;
    }

    EPropertiesKeys(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return getKey();
    }
}
