package com.appscharles.libs.proper.converters;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

/**
 * The type Properties converter.
 */
public class PropertiesConverter {

    public static String getString(Properties properties){
        StringWriter writer = new StringWriter();
        properties.list(new PrintWriter(writer));
        return writer.getBuffer().toString();
    }
}
