package io.rafaelmen.Repository;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import io.rafaelmen.Model.Followers;
import io.rafaelmen.Model.User;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
public class FollowerRepository implements PanacheRepository<Followers> {

    public boolean follows(User follower, User user) {
        var params = Parameters.with("follower", follower).and("user", user).map();
        PanacheQuery<Followers> query = find("follower = :follower and user = :user", params);
        Optional<Followers> result = query.firstResultOptional();
        return result.isPresent();
    }


    public List<Followers> findByUser(Long userId) {
        PanacheQuery<Followers> query = find("user.id", userId);
        return query.list();
    }
}
