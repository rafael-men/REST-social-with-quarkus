package io.rafaelmen.Repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.rafaelmen.Model.User;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
}
