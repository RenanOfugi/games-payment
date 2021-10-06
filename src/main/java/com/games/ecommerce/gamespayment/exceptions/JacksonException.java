package com.games.ecommerce.gamespayment.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;

public class JacksonException extends JsonProcessingException {
    protected JacksonException(String msg) {
        super(msg);
    }
}
