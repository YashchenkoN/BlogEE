package com.blogger.endpoint.user;

import com.blogger.entity.User;

import javax.ejb.Stateless;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

/**
 * @author Nikolay Yashchenko
 */
@Stateless
public class UserAuthEndpoint {

    @Path("/auth")
    @Consumes("application/x-www-form-urlencoded")
    @Produces("application/json")
    public Response login(@FormParam("email") String email,
                          @FormParam("password") String password,
                          @Context HttpServletRequest request) {
        // todo auth
        try {
            request.login(email, password);
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return Response.ok().build();
    }

    @POST
    @Path("/registration")
    @Consumes("application/json")
    @Produces("application/json")
    public Response registration(User user) {
        // todo add registration
        return Response.ok().build();
    }
}
