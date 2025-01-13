package io.rafaelmen.Rest;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.rafaelmen.Dto.CreatePostRequest;
import io.rafaelmen.Model.User;
import io.rafaelmen.Repository.UserRepository;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestHTTPEndpoint(PostResource.class)
class PostResourceTest {

    @Inject
    UserRepository userRepository;

    @BeforeEach
    @Transactional
    public void setUp() {
        var user = new User();
        user.setAge(30);
        user.setName("Jonas");
        userRepository.persist(user);
    }

    @Test
    public void createPostTest() {
        var postRequest = new CreatePostRequest();
        postRequest.setText("lorem ipsum..");
        var userId = 1;
        given().contentType(ContentType.JSON).body(postRequest).pathParam("userId",userId).when().post().then().statusCode(201);

    }
}