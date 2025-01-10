package io.rafaelmen.Model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "followers")
public class Followers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "follower_id")
    private User follower;

    public Followers(Long id, User user, User follower) {
        this.id = id;
        this.user = user;
        this.follower = follower;
    }

    public Followers() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
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
        Followers followers = (Followers) object;
        return Objects.equals(id, followers.id) && Objects.equals(user, followers.user) && Objects.equals(follower, followers.follower);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, follower);
    }
}
