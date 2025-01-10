package io.rafaelmen.Dto;

import java.util.Objects;

public class FollowerRequest {

    private Long followerId;

    public Long getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Long followerId) {
        this.followerId = followerId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        FollowerRequest that = (FollowerRequest) object;
        return Objects.equals(followerId, that.followerId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(followerId);
    }
}
