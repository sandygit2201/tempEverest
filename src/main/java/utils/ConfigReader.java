package utils;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private String configPropertiesFile = "config.properties";

    public String url() {

        return getConfigProperty("URL");
    }

    private String getConfigProperty(String property) {

        Properties properties = new PropertiesReader().readPropertyFile(configPropertiesFile);

        return properties.get(property).toString();
    }

}
