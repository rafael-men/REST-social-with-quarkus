package io.rafaelmen.Rest;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.rafaelmen.Dto.CreateUserRequest;
import io.rafaelmen.Model.User;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Map;
import java.util.Optional;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @POST
    @Transactional
    @Path("new")
    public Response createUser(CreateUserRequest request ) {
        User user = new User();
        user.setAge(request.getAge());
        user.setName(request.getName());

        user.persist();
        return Response.ok(request).build();
    }

    @GET
    public Response getAllUsers() {
        PanacheQuery<User> query = User.findAll();
        return Response.ok(query.list()).build();
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public Response deleteUser(@PathParam("id") Long id) {
        User user = User.findById(id);
        if(user != null) {
            user.delete();
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Response updateUser(@PathParam("id") Long id,CreateUserRequest userData) {

        User user = User.findById(id);

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
        User user = User.findById(id);

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
