package com.appscharles.libs.proper.containers;

import com.appscharles.libs.proper.TestCase;
import com.appscharles.libs.proper.exceptions.ProperException;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 06.08.2018
 * Time: 12:29
 * Project name: proper
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class CryptedPropertiesTest extends TestCase {

    @Test
    public void shouldSaveProperties() throws IOException, ProperException {
        File file = this.temp.newFile();
        String saltPassword = "ABSB#$";
        CryptedProperties properties = new CryptedProperties();
        properties.put("prop", "123ss");
        properties.put(CryptedProperties.class, "key", "12");
        properties.store(file, saltPassword);

        CryptedProperties properties2 = new CryptedProperties();
        properties2.load(file, saltPassword);
        Assert.assertTrue(properties2.containsKey("prop"));
        Assert.assertTrue(properties2.getProperty("prop").equals("123ss"));
        Assert.assertTrue(properties2.getProperty(CryptedProperties.class, "key").equals("12"));
    }
}