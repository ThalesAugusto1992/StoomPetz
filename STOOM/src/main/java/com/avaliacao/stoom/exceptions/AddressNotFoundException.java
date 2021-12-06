package com.avaliacao.stoom.exceptions;

public class AddressNotFoundException extends Exception {

    private static final String _DEFAULT_MSG = "Address not found!";

    public AddressNotFoundException() {
        super(_DEFAULT_MSG);
    }
}
