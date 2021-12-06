package com.avaliacao.stoom.exceptions;

public class AddressNotFoundOnGoogleAPIException extends Exception {

    private static final String _DEFAULT_MSG = "Address not found on google API!";

    public AddressNotFoundOnGoogleAPIException() {
        super(_DEFAULT_MSG);
    }
}
