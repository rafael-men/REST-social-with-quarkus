package io.rafaelmen.Dto;

import java.util.Objects;

public class CreatePostRequest {
    private String text;

    public CreatePostRequest() {
    }

    public CreatePostRequest(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        CreatePostRequest that = (CreatePostRequest) object;
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(text);
    }
}
