package configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentPropertiesLoader {

    static Properties props;

    static {
        props = loadProps();
    }

    public static Properties getProps() {
        return props;
    }

    private static Properties loadProps() {
        String env = System.getProperty(EPropertiesKeys.ENV.getKey().toLowerCase(), EPropertiesKeys.DEFAULT_ENV.getKey());
        String envPropertiesFile = (env + EPropertiesKeys.ENV_FILENAME_SUFFIX.getKey()).toLowerCase();
        try {
            String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
            Properties props = new Properties();
            props.load(new FileInputStream(rootPath + envPropertiesFile));
            return props;

        } catch (IOException ioe) {
            for (StackTraceElement ste : ioe.getStackTrace()) {
                System.out.println(ste.toString());
            }
        }
        return null;
    }
}
