package com.dci.drone_manager.exception;

public class NoDelivery extends Exception {
    public NoDelivery() {
        super("Entrega não existe.");
    }
}
