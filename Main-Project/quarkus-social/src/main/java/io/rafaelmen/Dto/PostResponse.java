package io.rafaelmen.Dto;

import io.rafaelmen.Model.Posts;
import java.time.LocalDateTime;
import java.util.Objects;

public class PostResponse {
    private String text;
    private LocalDateTime dateTime;


    public static PostResponse fromEntity(Posts post) {
        var response = new PostResponse();
        response.setText(post.getText());
        response.setDataTime(post.getDateTime());
        return response;
    }


    public PostResponse(String text, LocalDateTime dateTime) {
        this.text = text;
        this.dateTime = dateTime;
    }


    public PostResponse() {
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDataTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        PostResponse that = (PostResponse) object;
        return Objects.equals(text, that.text) && Objects.equals(dateTime, that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, dateTime);
    }
}
