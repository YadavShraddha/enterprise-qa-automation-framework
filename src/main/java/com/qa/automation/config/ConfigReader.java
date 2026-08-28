package com.qa.automation.config;

import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class ConfigReader {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input =
                     ConfigReader.class
                             .getClassLoader()
                             .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new RuntimeException(
                        "config.properties file not found"
                );
            }

            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Failed to load config.properties",
                    e
            );
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
