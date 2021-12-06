package com.avaliacao.stoom.exceptions;

public class MalformedBodyException extends Exception {

    private static final String _DEFAULT_MSG = "Body ID does not match with selected resource";

    public MalformedBodyException() {
        super(_DEFAULT_MSG);
    }
}