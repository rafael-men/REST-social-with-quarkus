package io.rafaelmen.Dto;

import io.rafaelmen.Model.Followers;

public class FollowerResponse {

    private Long id;
    private String name;

    // Construtor principal que evita NullPointerException
    public FollowerResponse(Followers follower) {
        this.id = follower.getId();
        this.name = follower.getFollower() != null ? follower.getFollower().getName() : null;
    }

    // Construtor vazio
    public FollowerResponse() {
    }

    // Construtor adicional para inicializar diretamente os campos
    public FollowerResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
