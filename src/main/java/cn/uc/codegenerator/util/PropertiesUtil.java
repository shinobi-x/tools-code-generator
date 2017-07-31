package cn.uc.codegenerator.util;

import java.util.Properties;

public class PropertiesUtil {
    private static Properties properties = new Properties();

    public static String getProperties(String key) throws Exception {
        properties.load(ClassLoader.getSystemResourceAsStream("config.properties"));
        String value = properties.getProperty(key);
        value = new String(value.getBytes("ISO-8859-1"), "UTF-8");
        return value;
    }
}
