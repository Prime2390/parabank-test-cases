package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream inputStream = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (inputStream == null) {
                throw new RuntimeException("Nie znaleziono pliku config.properties");
            }

            properties.load(inputStream);

        } catch (IOException e) {
            throw new RuntimeException("Błąd podczas wczytywania config.properties", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}