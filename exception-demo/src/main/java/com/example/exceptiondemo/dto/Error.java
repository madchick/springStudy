package com.example.exceptiondemo.dto;

public class Error {

    private String field;
    private String message;
    private String invalidValue;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInvalidValue() {
        return invalidValue;
    }

    public void setInvalidValue(String invalidValue) {
        this.invalidValue = invalidValue;
    }

    @Override
    public String toString() {
        return "Error{" +
                "field='" + field + '\'' +
                ", message='" + message + '\'' +
                ", invalidValue='" + invalidValue + '\'' +
                '}';
    }

}
