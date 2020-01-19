package com.personal.learning.journal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EntryNotSavedException extends RuntimeException{

    public EntryNotSavedException(String s){super(s);}
}
