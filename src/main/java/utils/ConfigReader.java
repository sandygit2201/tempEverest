package utils;

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
