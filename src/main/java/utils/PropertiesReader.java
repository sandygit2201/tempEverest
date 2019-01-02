package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    public Properties readPropertyFile(String filePath){

        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;

    }
}
