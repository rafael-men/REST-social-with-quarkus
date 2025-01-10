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
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Posts() {
    }

    public Posts(Long id, LocalDateTime dateTime, String text, User user) {
        this.id = id;
        this.dateTime = dateTime;
        this.text = text;
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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
        return Objects.equals(id, posts.id) && Objects.equals(text, posts.text) && Objects.equals(dateTime, posts.dateTime) && Objects.equals(user, posts.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, dateTime, user);
    }
}
