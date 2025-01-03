package io.rafaelmen.Rest;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.rafaelmen.Dto.CreateUserRequest;
import io.rafaelmen.Dto.ResponseError;
import io.rafaelmen.Model.User;
import io.rafaelmen.Repository.UserRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.util.Map;
import java.util.Set;


@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    private final UserRepository repository;

    private final jakarta.validation.Validator validator;

    @Inject
    public UserResource (UserRepository repository, jakarta.validation.Validator validator) {
        this.repository = repository;
        this.validator = (jakarta.validation.Validator) validator;
    }
    @POST
    @Transactional
    @Path("new")
    public Response createUser(CreateUserRequest request) throws IOException, SAXException {
        Set<ConstraintViolation<CreateUserRequest>> violations = validator.validate(request);
        if(violations.isEmpty()) {
            ResponseError responseError = ResponseError.createFromValidation(violations);
            return Response.status(400).entity(responseError).build();
        }
        User user = new User();
        user.setAge(request.getAge());
        user.setName(request.getName());
        repository.persist(user);
        return Response.ok(user).build();
    }


    @GET
    public Response getAllUsers() {
        PanacheQuery<User> query = repository.findAll();
        return Response.ok(query.list()).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response deleteUser(@PathParam("id") Long id) {
        User user = repository.findById(id);
        if(user != null) {
            repository.delete(user);
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response updateUser(@PathParam("id") Long id,CreateUserRequest userData) {

        User user = repository.findById(id);

        if(user != null) {
            user.setName(userData.getName());
            user.setAge(userData.getAge());
            return Response.ok().build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PATCH
    @Path("{id}")
    @Transactional
    public Response partiallyUpdate(@PathParam("id") Long id, Map<String, Object> updates) {
        User user = repository.findById(id);

        if (user != null) {
            updates.forEach((key, value) -> {
                switch (key) {
                    case "name":
                        user.setName((String) value);
                        break;
                    case "age":
                        user.setAge((Integer) value);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid field: " + key);
                }
            });

            return Response.ok().build();
        }

        return Response.status(Response.Status.NOT_FOUND).build();
    }

}
