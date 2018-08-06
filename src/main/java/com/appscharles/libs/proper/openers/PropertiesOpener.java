package com.appscharles.libs.proper.openers;

import com.appscharles.libs.ioer.services.FileReader;
import com.appscharles.libs.proper.containers.CryptedProperties;
import com.appscharles.libs.proper.exceptions.ProperException;
import org.jasypt.util.text.StrongTextEncryptor;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 06.08.2018
 * Time: 12:12
 * Project name: proper
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public class PropertiesOpener extends AbstractOpener{

    private File file;

    private String saltPassword;

    /**
     * Instantiates a new Encode saver.
     *
     * @param file         the file
     * @param saltPassword the salt password
     */
    public PropertiesOpener(File file, String saltPassword) {
        this.file = file;
        this.saltPassword = saltPassword;
    }

    @Override
    public CryptedProperties open() throws ProperException {
        StrongTextEncryptor textEncryptor = new StrongTextEncryptor();
        textEncryptor.setPassword(this.saltPassword);
        String propertiesString;
        try {
            propertiesString = textEncryptor.decrypt(FileReader.read(this.file));
            CryptedProperties cryptedProperties = new CryptedProperties();
            cryptedProperties.load(new StringReader(propertiesString));
            return cryptedProperties;
        } catch (IOException e) {
            throw new ProperException(e);
        }
    }
}
