package com.promptledger.gateway.provider;

public class UnsupportedModelException extends RuntimeException {

    public UnsupportedModelException(String model) {
        super("No provider supports model: " + model);
    }
}
