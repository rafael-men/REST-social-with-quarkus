package io.rafaelmen.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "posts")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @Column(name = "date_time")
    private LocalDateTime dataTime;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Posts() {
    }

    public Posts(Long id, LocalDateTime dataTime, String text, User user) {
        this.id = id;
        this.dataTime = dataTime;
        this.text = text;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Posts posts = (Posts) object;
        return Objects.equals(id, posts.id) && Objects.equals(text, posts.text) && Objects.equals(dataTime, posts.dataTime) && Objects.equals(user, posts.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, dataTime, user);
    }
}
