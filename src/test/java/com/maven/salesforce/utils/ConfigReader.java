package com.maven.salesforce.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;

    public ConfigReader() {
        try (FileInputStream input = new FileInputStream("test/resources/config.properties")) {
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

	public void load(FileInputStream configFile) {
		// TODO Auto-generated method stub
		
	}
}
