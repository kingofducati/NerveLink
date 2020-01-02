package org.nervelinkin.core.exception;

public class NeuronAddressException extends Exception {
    public NeuronAddressException(String message) {
        super(message);
    }

    public NeuronAddressException(String message, Throwable cause) {
        super(message, cause);
    }
}
