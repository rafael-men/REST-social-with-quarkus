package io.rafaelmen.Rest;

import io.rafaelmen.Dto.FollowerRequest;
import io.rafaelmen.Model.Followers;
import io.rafaelmen.Repository.FollowerRepository;
import io.rafaelmen.Repository.UserRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users/{userId}/followers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FollowerResource {

    private final UserRepository userRepository;
    private final FollowerRepository followerRepository;

    @Inject
    public FollowerResource(UserRepository userRepository, FollowerRepository followerRepository) {
        this.userRepository = userRepository;
        this.followerRepository = followerRepository;
    }

    @PUT
    @Transactional
    public Response followUser(@PathParam("userId") Long userId, FollowerRequest request) {
        if(userId.equals(request.getFollowerId())) {
            return Response.status(Response.Status.CONFLICT).entity("You can't follow yourself").build();
        }
        var user = userRepository.findById(userId);
        if(user == null) {
            return Response.status((Response.StatusType) Response.status(Response.Status.NOT_FOUND)).build();
        }

        var follower = userRepository.findById(request.getFollowerId());
        boolean follows = followerRepository.follows(follower,user);
        if(!follows) {
            var entity = new Followers();
            entity.setUser(user);
            entity.setFollower(follower);

            followerRepository.persist(entity);
        }

        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
