package io.rafaelmen.Rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.awt.*;

@Path("/users/{userId}/posts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PostResource {

    // endpoints de postagens
    
    @POST
    public Response createPost() {
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public Response getPosts(){
        return Response.ok().build();
    }
}
