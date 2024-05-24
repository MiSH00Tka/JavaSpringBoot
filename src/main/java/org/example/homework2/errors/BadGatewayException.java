package org.example.homework2.errors;


public class BadGatewayException extends RuntimeException{

    private final String code = "BAD_GATEWAY";

    public BadGatewayException(Long entityId) {
        super("Bad Gateway №" + entityId);
    }

    public String getCode() {
        return code;
    }
}
