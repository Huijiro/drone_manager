package com.dci.drone_manager.exception;

public class NoDrone extends Exception {
    public NoDrone() {
        super("Drone não existe.");
    }
}
