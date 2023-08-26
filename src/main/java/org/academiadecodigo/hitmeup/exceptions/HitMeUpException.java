package org.academiadecodigo.hitmeup.exceptions;

/**
 * A generic java bank exception to be used as base for concrete types of exceptions
 *
 * @see Exception
 */
public class HitMeUpException extends Exception {

    /**
     * @see Exception#Exception(String)
     */
    public HitMeUpException(String message) {
        super(message);
    }
}
