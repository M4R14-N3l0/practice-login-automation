package support;

import org.apache.commons.configuration.PropertiesConfiguration;

public class Config {
    private static PropertiesConfiguration config;

    static {
        try {
            config = new PropertiesConfiguration("config/test.properties");
        } catch (Exception e) {
            throw new RuntimeException("No se pudo cargar config/test.properties", e);
        }
    }

    public static String get(String key) {
        return config.getString(key);
    }
}
