package com.games.ecommerce.gamespayment.exceptions;

import com.fasterxml.jackson.core.JsonProcessingException;

public class ConvertDataException extends JsonProcessingException {
    public ConvertDataException(final String msg) {
        super(msg);
    }
}
