package com.blogger.endpoint.post;

import com.blogger.converter.PostDTOtoPostConverter;
import com.blogger.converter.PostToPostDTOConverter;
import com.blogger.dto.PostDTO;
import com.blogger.service.PostService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Nikolay Yashchenko
 */
@Path("/post")
@Stateless
public class PostEndpoint {

    @Inject
    private PostService postService;

    @Inject
    private PostDTOtoPostConverter converterToEntity;

    @Inject
    private PostToPostDTOConverter converterToDTO;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPosts(@PathParam("offset") int offset,
                             @PathParam("stepSize") int stepSize,
                             @PathParam("sort") String sort,
                             @PathParam("userId") Long userId) {
        if(stepSize <= 0) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .build();
        }
        List<PostDTO> postDTOs = postService.getByParameters(offset, stepSize, sort, userId).stream()
                .map(converterToDTO::convert)
                .collect(Collectors.toList());
        return Response.ok()
                .entity(postDTOs)
                .build();
    }
}
