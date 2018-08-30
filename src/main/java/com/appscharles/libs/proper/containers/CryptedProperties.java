package com.appscharles.libs.proper.containers;

import com.appscharles.libs.proper.exceptions.ProperException;
import com.appscharles.libs.proper.openers.IOpener;
import com.appscharles.libs.proper.openers.PropertiesOpener;
import com.appscharles.libs.proper.savers.ISaver;
import com.appscharles.libs.proper.savers.PropertiesSaver;

import java.io.File;
import java.util.Properties;

/**
 * The type Crypted properties.
 */
public class CryptedProperties extends Properties {

    private File file;

    private String saltPassword;

    /**
     * Load.
     *
     * @param file         the file
     * @param saltPassword the salt password
     * @throws ProperException the proper exception
     */
    public synchronized void load(File file, String saltPassword) throws ProperException {
        this.file = file;
        this.saltPassword = saltPassword;
        IOpener opener = new PropertiesOpener(file, saltPassword);
        CryptedProperties cryptedProperties = opener.open();
        this.clear();
        this.putAll(cryptedProperties);
    }

    /**
     * Store.
     *
     * @param file         the file
     * @param saltPassword the salt password
     * @throws ProperException the proper exception
     */
    public void store(File file, String saltPassword) throws ProperException {
        ISaver saver = new PropertiesSaver(this, file, saltPassword);
        saver.save();
    }

    /**
     * Put object.
     *
     * @param aClass the a class
     * @param key    the key
     * @param value  the value
     * @return the object
     */
    public synchronized Object put(Class aClass, Object key, Object value) {
        return super.put(aClass.getName() + "." + key, value);
    }

    /**
     * Put and store object.
     *
     * @param aClass the a class
     * @param key    the key
     * @param value  the value
     * @return the object
     * @throws ProperException the proper exception
     */
    public synchronized Object putAndStore(Class aClass, Object key, Object value) throws ProperException {
        if (this.file == null || this.saltPassword == null){
            throw new ProperException("Before use this method, must load file properties.");
        }
        Object result = super.put(aClass.getName() + "." + key, value);
        store(this.file, this.saltPassword);
        return result;
    }

    /**
     * Gets property.
     *
     * @param aClass the a class
     * @param key    the key
     * @return the property
     */
    public String getProperty(Class aClass, String key) {
        return super.getProperty(aClass.getName() + "." + key);
    }

    /**
     * Gets property.
     *
     * @param aClass       the a class
     * @param key          the key
     * @param defaultValue the default value
     * @return the property
     */
    public String getProperty(Class aClass, String key, String defaultValue) {
        return super.getProperty(aClass.getName() + "." + key, defaultValue);
    }

    /**
     * Contains key boolean.
     *
     * @param aClass the a class
     * @param key    the key
     * @return the boolean
     */
    public synchronized boolean containsKey(Class aClass, Object key) {
        return super.containsKey(aClass.getName() + "." + key);
    }
}
