package io.rafaelmen.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.rafaelmen.Model.Posts;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PostRepository implements PanacheRepository<Posts> {
}
