package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private Properties properties;
    private InputStream inputStream;

    public Properties readPropertyFile(String filePath) {

        properties = new Properties();
        inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;

    }
}
