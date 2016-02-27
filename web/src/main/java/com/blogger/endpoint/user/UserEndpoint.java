package com.blogger.endpoint.user;

import com.blogger.entity.User;
import com.blogger.service.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * @author Nikolay Yashchenko
 */
@Path("/user")
@Stateless
public class UserEndpoint {

    @Inject
    private UserService userService;

    @GET
    @Path("/")
    @Produces("application/json")
    public Response getAllUsers(@QueryParam("offset") int offset,
                                @QueryParam("stepSize") int stepSize) {
        if(stepSize <= 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .build();
        }
        return Response.status(Response.Status.OK)
                .entity(userService.getUsers(offset, stepSize))
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getUser(@PathParam("id") Long userId) {
        if(userId <= 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .build();
        }
        return Response.status(Response.Status.OK)
                .entity(userService.read(userId))
                .build();
    }

    @POST
    @Path("/")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createUser(@Valid User user) {
        return Response.ok()
                .entity(userService.create(user))
                .build();
    }

    @PUT
    @Path("/")
    @Produces("application/json")
    @Consumes("application/json")
    public Response updateUser(@Valid User user) {
        return Response.ok()
                .entity(userService.update(user))
                .build();
    }

    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    public Response deleteUser(@PathParam("id") Long userId) {
        if(userId > 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .build();
        }
//        userService.delete();
        return Response.ok()
                .build();

    }
}
