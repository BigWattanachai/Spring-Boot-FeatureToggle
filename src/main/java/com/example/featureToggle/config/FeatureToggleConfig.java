package com.example.featureToggle.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
@ConfigurationProperties(prefix = "featureToggle")
public class FeatureToggleConfig {

    private static HashMap<String, String> properties;

    public HashMap<String, String> getProperties() {
        return properties;
    }

    public void setProperties(HashMap<String, String> properties) {
        FeatureToggleConfig.properties = properties;
    }

    public static String getProperty(String feature) {
        return properties.get(feature);
    }
}
