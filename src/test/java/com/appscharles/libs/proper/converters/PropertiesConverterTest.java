package com.appscharles.libs.proper.converters;

import org.junit.Assert;
import org.junit.Test;

import java.util.Properties;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 06.08.2018
 * Time: 11:49
 * Project name: proper
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class PropertiesConverterTest {

    @Test
    public void shouldConvertPropertiesToString(){
        Properties properties = new Properties();
        properties.put("prop", "ąćś");
        Assert.assertTrue(PropertiesConverter.getString(properties).contains("ąćś"));
    }
}