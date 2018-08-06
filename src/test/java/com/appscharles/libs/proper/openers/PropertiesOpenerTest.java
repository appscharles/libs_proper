package com.appscharles.libs.proper.openers;

import com.appscharles.libs.ioer.services.FileReader;
import com.appscharles.libs.proper.TestCase;
import com.appscharles.libs.proper.containers.CryptedProperties;
import com.appscharles.libs.proper.exceptions.ProperException;
import com.appscharles.libs.proper.savers.ISaver;
import com.appscharles.libs.proper.savers.PropertiesSaver;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 06.08.2018
 * Time: 12:17
 * Project name: proper
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class PropertiesOpenerTest extends TestCase {

    @Test
    public void shouldOpenEncryptedProperties() throws IOException, ProperException {
        String saltPassword = "ABSC";
        File file = this.temp.newFile();
        Properties properties = new Properties();
        properties.put("prop", "1234");
        ISaver saver = new PropertiesSaver(properties, file, saltPassword);
        saver.save();
        String encodedProperties = FileReader.read(file);
        Assert.assertFalse(encodedProperties.contains("1234"));

        IOpener opener = new PropertiesOpener(file, saltPassword);
        CryptedProperties cryptedProperties = opener.open();
        Assert.assertTrue(cryptedProperties.containsKey("prop"));
    }
}