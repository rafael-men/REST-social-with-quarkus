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

@QuarkusTest
@TestHTTPEndpoint(PostResource.class)
class PostResourceTest {

    @Inject
    UserRepository userRepository;

    private Long userId;

    @BeforeEach
    @Transactional
    public void setUp() {
        // Criação e persistência de um usuário para o teste
        var user = new User();
        user.setAge(30);
        user.setName("Jonas");
        userRepository.persist(user);
        userRepository.flush();
        userId = user.getId();
    }

    @Test
    public void createPostTest() {
        // Preparação da requisição de criação de post
        var postRequest = new CreatePostRequest();
        postRequest.setText("lorem ipsum...");

        // Execução do teste
        given()
                .contentType(ContentType.JSON)
                .body(postRequest)
                .pathParam("userId", userId)
                .when()
                .post("/{userId}/new");
    }
}
