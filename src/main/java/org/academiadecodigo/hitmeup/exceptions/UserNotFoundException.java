package org.academiadecodigo.hitmeup.exceptions;

import org.academiadecodigo.hitmeup.errors.ErrorMessage;

/**
 * Thrown to indicate that the customer was not found
 */
public class UserNotFoundException extends HitMeUpException {

    /**
     * @see HitMeUpException#HitMeUpException(String)
     */
    public UserNotFoundException() {
        super(ErrorMessage.USER_NOT_FOUND);
    }
}
