package com.blogger.endpoint.user;

import com.blogger.converter.Converter;
import com.blogger.dto.UserDTO;
import com.blogger.entity.User;
import com.blogger.service.UserService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Nikolay Yashchenko
 */
@Path("/user")
@Stateless
public class UserEndpoint {

    @Inject
    private UserService userService;

    @Inject
    private Converter<UserDTO, User> converterToEntity;

    @Inject
    private Converter<User, UserDTO> converterToDTO;

    @GET
    @Path("/")
    @Produces("application/json")
    public Response getAllUsers(@QueryParam("offset") int offset,
                                @QueryParam("stepSize") int stepSize) {
        if(stepSize <= 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .build();
        }
        List<UserDTO> userDTOs = userService.getUsers(offset, stepSize).stream()
                .map(converterToDTO::convert)
                .collect(Collectors.toList());
        return Response.status(Response.Status.OK)
                .entity(userDTOs)
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getUser(@PathParam("id") Long userId) {
        if(userId <= 0L) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .build();
        }
        return Response.status(Response.Status.OK)
                .entity(converterToDTO.convert(userService.read(userId)))
                .build();
    }

    @POST
    @Path("/")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createUser(@Valid UserDTO userDTO) {
        User user = userService.create(converterToEntity.convert(userDTO));
        return Response.ok()
                .entity(converterToDTO.convert(user))
                .build();
    }

    @PUT
    @Path("/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response updateUser(@PathParam("id") Long userId, @Valid UserDTO userDTO) {
        if(userId <= 0L) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .build();
        }
        userDTO.setUserId(userId);
        User user = userService.update(converterToEntity.convert(userDTO));
        return Response.ok()
                .entity(converterToDTO.convert(user))
                .build();
    }

    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    public Response deleteUser(@PathParam("id") Long userId) {
        if(userId > 0L) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .build();
        }
        userService.delete(userService.read(userId));
        return Response.ok()
                .build();

    }
}
