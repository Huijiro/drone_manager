package com.dci.drone_manager.exception;

public class NoDroneAvailable extends Exception {
    public NoDroneAvailable() {
        super("Nenhum drone disponível.");
    }
}
