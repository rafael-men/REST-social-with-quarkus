package io.rafaelmen.Rest;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Sort;
import io.rafaelmen.Dto.CreatePostRequest;
import io.rafaelmen.Dto.PostResponse;
import io.rafaelmen.Model.Posts;
import io.rafaelmen.Model.User;
import io.rafaelmen.Repository.PostRepository;
import io.rafaelmen.Repository.UserRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Path("/users/{userId}/posts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PostResource {

    private final UserRepository repository;
    private final PostRepository postRepository;

    @Inject
    public PostResource(UserRepository repository, PostRepository postRepository) {
        this.repository = repository;
        this.postRepository = postRepository;
    }

    // endpoints de postagens
    
    @POST
    @Path("/new")
    @Transactional
    public Response createPost(@PathParam("userId") Long userId, CreatePostRequest request) {
        User user = repository.findById(userId);
        if(user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Posts post = new Posts();
        post.setText(request.getText());
        post.setUser(user);
        post.setDataTime(LocalDateTime.now());
        postRepository.persist(post);
        return Response.status(Response.Status.CREATED).build();
    }

    @GET
    public Response getPosts(@PathParam("userId") Long userId){
        User user = repository.findById(userId);
        if(user == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    PanacheQuery<Posts> query = postRepository.find("user", Sort.by("dataTime", Sort.Direction.Ascending),user);
        var list = query.list();
        var postResponseList = list.stream().map(PostResponse::fromEntity).collect(Collectors.toList());
        return Response.ok(postResponseList).build();
    }

    @PUT
    @Path("/{postId}")
    @Transactional
    public Response replacePost(@PathParam("userId") Long userId,
                                @PathParam("postId") Long postId,
                                CreatePostRequest request) {
        User user = repository.findById(userId);
        if (user == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("User not found").build();
        }
        Posts post = postRepository.findById(postId);
        if (post == null || !post.getUser().getId().equals(userId)) {
            return Response.status(Response.Status.NOT_FOUND).entity("Post not found or does not belong to the user").build();
        }
        if (request.getText() != null) {
            post.setText(request.getText());
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Text field is required").build();
        }

        postRepository.persist(post);

        return Response.ok(post).build();
    }


}
