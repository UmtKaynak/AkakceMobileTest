package mobilautomation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try {
            String osType = System.getProperty("os.name");
            String propertyPath = "/src/test/resources/configration.properties";

            if (osType.toLowerCase().contains("win")) {
                propertyPath = propertyPath.replace("/", "\\");
            }

            FileInputStream propertiesStream = new FileInputStream(System.getProperty("user.dir") + propertyPath);
            properties.load(new InputStreamReader(propertiesStream, StandardCharsets.UTF_8));
            propertiesStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Config file not found at specified path.");
        }
    }
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
