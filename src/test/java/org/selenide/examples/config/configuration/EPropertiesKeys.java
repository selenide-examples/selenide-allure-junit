package org.selenide.examples.config.configuration;

public enum EPropertiesKeys {
    BASE_URL("base.url"),
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
