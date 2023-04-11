package com.dci.drone_manager.exception;

public class NoField extends Exception {
    public NoField(String field) {
        super("Campo " + field + " não existe");
    }
}
