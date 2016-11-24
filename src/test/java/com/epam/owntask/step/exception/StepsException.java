package com.epam.owntask.step.exception;

/**
 * Created by Davud_Murtazin on 11/24/2016.
 */
public class StepsException extends Exception{
    public StepsException() {
    }

    public StepsException(String message) {
        super(message);
    }

    public StepsException(String message, Throwable cause) {
        super(message, cause);
    }

    public StepsException(Throwable cause) {
        super(cause);
    }

    public StepsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
