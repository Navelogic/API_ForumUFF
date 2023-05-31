package br.com.apiuff.config;

import org.springframework.validation.FieldError;

import java.util.List;

public class ErrorFormDTO {
    private String field;
    private String error;

    // Constructor
    public ErrorFormDTO(String field, String error) {
        this.field = field;
        this.error = error;
    }

    // Getters
    public String getField() {
        return field;
    }

    public String getError() {
        return error;
    }

}
