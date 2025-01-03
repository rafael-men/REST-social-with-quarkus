package io.rafaelmen.Error;

public class FieldError {
    private String field;
    private String message;

    public FieldError(String message, String field) {
        this.message = message;
        this.field = field;
    }

    public FieldError() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
