package io.rafaelmen.Rest;

import io.quarkus.test.junit.QuarkusTest;
import io.rafaelmen.Dto.CreateUserRequest;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class UserResourceTest {

    @Test
    public void createUserTest() {
        var user = new CreateUserRequest();
        user.setName("Lucas");
        user.setAge(37);

        var response = given()
                .contentType(ContentType.JSON)
                .body(user, ObjectMapperType.JACKSON_2)
                .when()
                .post("/users/new")
                .then()
                .extract()
                .response();
        assertNotNull(response.jsonPath().getString("id"));
    }

}