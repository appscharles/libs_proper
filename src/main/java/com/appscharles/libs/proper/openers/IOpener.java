package com.appscharles.libs.proper.openers;

import com.appscharles.libs.proper.containers.CryptedProperties;
import com.appscharles.libs.proper.exceptions.ProperException;

/**
 * IDE Editor: IntelliJ IDEA
 * <p>
 * Date: 06.08.2018
 * Time: 11:53
 * Project name: proper
 *
 * @author Karol Golec karol.itgolo@gmail.com
 */
public interface IOpener {

    CryptedProperties open() throws ProperException;
}
