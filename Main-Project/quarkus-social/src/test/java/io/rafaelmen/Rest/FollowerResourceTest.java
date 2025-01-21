package io.rafaelmen.Rest;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.rafaelmen.Dto.FollowerRequest;
import io.rafaelmen.Model.User;
import io.rafaelmen.Repository.FollowerRepository;
import io.rafaelmen.Repository.UserRepository;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestHTTPEndpoint(FollowerResource.class)
class FollowerResourceTest {

    @Inject
    UserRepository userRepository;

    @Inject
    FollowerRepository followerRepository;

    Long userId;

    @BeforeEach
    @Transactional
    void setUp() {
        var user = new User();
        user.setAge(30);
        user.setName("Jonas");
        userRepository.persist(user);
        userId = user.getId();
    }

    @Test
    public void sameUserTest() {
        var body = new FollowerRequest();
        body.setFollowerId(userId);

        given().contentType(ContentType.JSON).body(body).pathParam("userId",userId)
                .when().put().then().statusCode(Response.Status.CONFLICT.getStatusCode());

    }
}