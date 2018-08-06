package com.appscharles.libs.proper.savers;

import java.util.Properties;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 06.08.2018
 * Time: 12:01
 * Project name: proper
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public abstract class AbstractSaver implements ISaver {

    protected Properties properties;

    public AbstractSaver(Properties properties) {
        this.properties = properties;
    }
}
