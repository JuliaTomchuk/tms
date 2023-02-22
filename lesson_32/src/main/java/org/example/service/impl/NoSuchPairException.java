package org.example.service.impl;

public class NoSuchPairException extends Exception {
    public NoSuchPairException() {
        super();
    }

    public NoSuchPairException(String message) {
        super(message);
    }

    public NoSuchPairException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchPairException(Throwable cause) {
        super(cause);
    }

    protected NoSuchPairException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
