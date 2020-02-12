package org.selenide.examples.config.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentPropertiesLoader {

    static Properties props;

    static {
        props = loadProps();
    }

    public static Properties getEnvProps() {
        return props;
    }

    private static Properties loadProps() {

        String env = System.getProperty(EPropertiesKeys.ENV.getKey(), EPropertiesKeys.DEFAULT_ENV.getKey());
        String envPropertiesFile = (env + EPropertiesKeys.ENV_FILENAME_SUFFIX.getKey()).toLowerCase();
        try {
            String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            Properties properties = new Properties();
            properties.load(new FileInputStream(rootPath + envPropertiesFile));
            return properties;
        } catch (IOException ioe) {
            for (StackTraceElement ste : ioe.getStackTrace()) {
                System.out.println("Failed to load properties due to:" + ste.toString());
            }
            return new Properties();
        }

    }
}
