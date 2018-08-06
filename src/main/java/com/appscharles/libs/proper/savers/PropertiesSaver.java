package com.appscharles.libs.proper.savers;

import com.appscharles.libs.ioer.services.FileWriter;
import com.appscharles.libs.proper.converters.PropertiesConverter;
import com.appscharles.libs.proper.exceptions.ProperException;
import org.jasypt.util.text.StrongTextEncryptor;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * The type Encode saver.
 */
public class PropertiesSaver extends AbstractSaver {

    private File file;

    private String saltPassword;

    /**
     * Instantiates a new Encode saver.
     *
     * @param properties   the properties
     * @param file         the file
     * @param saltPassword the salt password
     */
    public PropertiesSaver(Properties properties, File file, String saltPassword) {
        super(properties);
        this.file = file;
        this.saltPassword = saltPassword;
    }

    @Override
    public void save() throws ProperException {
        StrongTextEncryptor textEncryptor = new StrongTextEncryptor();
        textEncryptor.setPassword(this.saltPassword);
        String encryptedProperties = textEncryptor.encrypt(PropertiesConverter.getString(this.properties));
        try {
            FileWriter.write(this.file, encryptedProperties);
        } catch (IOException e) {
            throw new ProperException(e);
        }
    }
}
