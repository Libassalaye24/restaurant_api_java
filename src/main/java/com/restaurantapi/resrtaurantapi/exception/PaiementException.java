package com.restaurantapi.resrtaurantapi.exception;

public class PaiementException extends CommandeException {
    public PaiementException(String message) {
        super(message);
    }

    public PaiementException(String message, Throwable cause) {
        super(message, cause);
    }
}
