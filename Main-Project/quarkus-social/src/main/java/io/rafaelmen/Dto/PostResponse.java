package io.rafaelmen.Dto;

import io.rafaelmen.Model.Posts;
import jakarta.ws.rs.core.Response;

import java.time.LocalDateTime;
import java.util.Objects;

public class PostResponse {
    private String text;
    private LocalDateTime dataTime;

    public static PostResponse fromEntity(Posts post) {
        var response = new PostResponse();
        response.setText(response.getText());
        response.setDataTime(response.getDataTime());
        return response;
    }

    public PostResponse(String text, LocalDateTime dataTime) {
        this.text = text;
        this.dataTime = dataTime;
    }

    public PostResponse() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getDataTime() {
        return dataTime;
    }

    public void setDataTime(LocalDateTime dataTime) {
        this.dataTime = dataTime;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        PostResponse that = (PostResponse) object;
        return Objects.equals(text, that.text) && Objects.equals(dataTime, that.dataTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, dataTime);
    }
}

