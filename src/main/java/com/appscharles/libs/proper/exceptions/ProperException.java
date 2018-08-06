package com.appscharles.libs.proper.exceptions;

/**
 * The type Proper exception.
 */
public class ProperException extends Exception {

    /**
     * The Serial version uid.
     */
    static final long serialVersionUID = 7821375128146530432L;

    /**
     * Instantiates a new Proper exception.
     */
    public ProperException() {
        super();
    }

    /**
     * Instantiates a new Proper exception.
     *
     * @param message the message
     */
    public ProperException(String message) {
        super(message);
    }

    /**
     * Instantiates a new Proper exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ProperException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Proper exception.
     *
     * @param cause the cause
     */
    public ProperException(Throwable cause) {
        super(cause);
    }

}

